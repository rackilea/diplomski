package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.example.demo.QFermateM;

import java.util.List;

@Repository
public interface lineeRepository extends MongoRepository<FermateM, String>, QuerydslPredicateExecutor<FermateM> {
    FermateM findBy_id(ObjectId _id);
    @Query( value = "{}", fields = "{idlinea : 1}" )
    List<String> getIDlinea();
}