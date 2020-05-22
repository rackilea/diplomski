package com.example.demo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@Document("linee")
public class FermateM {
    @Id
    public ObjectId _id;
    private String idlinea;
    private List<String> fermate;

}