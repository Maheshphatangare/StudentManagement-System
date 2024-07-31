package com.mongo.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mongo.entity.Stud;

public interface StudRepo extends MongoRepository<Stud,Integer>{
	//@Query("from Stud as c where c.stud.id=:id")
Page<Stud>findById(int id ,Pageable pageable);
}
