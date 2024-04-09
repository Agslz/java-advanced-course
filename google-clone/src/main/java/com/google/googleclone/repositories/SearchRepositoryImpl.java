package com.google.googleclone.repositories;

import com.google.googleclone.entities.WebPage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SearchRepositoryImpl implements SearchRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<WebPage> search(String textSearch) {
        String query = "SELECT w FROM WebPage w WHERE w.description LIKE :textSearch";
        return entityManager
                .createQuery(query)
                .setParameter("textSearch", "%" + textSearch + "%")
                .getResultList();
    }

}
