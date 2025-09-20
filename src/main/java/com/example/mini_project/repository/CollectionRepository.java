package com.example.mini_project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mini_project.model.Collection;

@Repository
public interface CollectionRepository extends MongoRepository<Collection, String> {
}