package com.example.mini_project.service;

import com.example.mini_project.model.Collection;
import com.example.mini_project.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public Collection createCollection(Collection collection) {
        // Set current date if not provided
        if (collection.getDate() == null) {
            collection.setDate(new Date());
        }
        return collectionRepository.save(collection);
    }
}