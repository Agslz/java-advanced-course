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

    @Override
    public WebPage getByUrl(String url) {
        String query = "SELECT w FROM WebPage w WHERE w.url = :url";
        List<WebPage> list = entityManager.createQuery(query)
                .setParameter("url", url)
                .getResultList();
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public List<WebPage> getLinksToIndex() {
        String query = "SELECT w FROM WebPage w WHERE w.title is null AND w.description is null";
        return entityManager
                .createQuery(query)
                .setMaxResults(100)
                .getResultList();
    }

    @Override
    @Transactional
    public List<WebPage> search(String textSearch) {
        String query = "SELECT w FROM WebPage w WHERE w.description LIKE :textSearch";
        return entityManager
                .createQuery(query)
                .setParameter("textSearch", "%" + textSearch + "%")
                .getResultList();
    }

    @Override
    @Transactional
    public void save(WebPage webPage) {
        entityManager.merge(webPage);
    }

    @Override
    public boolean exist(String url) {
       return getByUrl(url) != null;
    }

}
