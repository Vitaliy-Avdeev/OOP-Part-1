package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.comparator.ComparatorOfOrder;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.*;


public class SearchEngine {
    Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }
    public TreeSet<Searchable> search(String searchTerm) {
        TreeSet<Searchable> results = new TreeSet<>(new ComparatorOfOrder());
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchTerm)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public Searchable getSearchBestMatch(String search) throws BestResultNotFound {
        int maxScore = 0;
        Searchable result = null;
        for (Searchable searchable : searchables) {
            int score = countingIncomingElements(searchable.getSearchTerm(), search);
            if ((searchable != null) && (score > maxScore)) {
                maxScore = score;
                result = searchable;
            }
        }
        if (result == null) throw new BestResultNotFound("Для " + search + " запроса не нашлось");
        return result;
    }

    public int countingIncomingElements(String str, String subStr) {
        int count = 0;
        for (int index = 0; (index = str.indexOf(subStr, index)) != -1; index += subStr.length()) {
            count++;
        }
        return count;
    }
}

