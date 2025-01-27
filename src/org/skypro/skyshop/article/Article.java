package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

public record Article(String articleTitle, String articleText) implements Searchable {

    @Override
    public String toString() {
        return "Название статьи: " + articleTitle() + '\n' + "Текст статьи: " + articleText();
    }

    @Override
    public String getSearchTerm() {
        return this + " " + getType();
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return articleTitle + " \nТип - ARTICLE";
    }


    @Override
    public String getName() {
        return articleTitle;
    }
}
