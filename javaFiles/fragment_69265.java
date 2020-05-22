package com.myproject.project;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface HelloRepository extends CrudRepository<BufferConditionEntity, Long> {
}