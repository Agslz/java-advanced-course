package com.google.googleclone.repositories;

import com.google.googleclone.entities.WebPage;

import java.util.List;

public interface SearchRepository {

    List<WebPage> search(String textSearch);

}

