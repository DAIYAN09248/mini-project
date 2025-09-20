package com.example.mini_project.repository;

import com.example.mini_project.model.Recharge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeRepository extends MongoRepository<Recharge, String> {
}