package com.example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "tags", path="tag")
public interface TagRepository extends MongoRepository<Tag, String>
{
    @RestResource(path = "tags")
    Page<Tag> findAll(Pageable pageable);

    void delete(String tag);
}