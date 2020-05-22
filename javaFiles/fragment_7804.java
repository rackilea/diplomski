package com.mongo.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDateTest {

    public static void main(String args[]){

        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase database = mongoClient.getDatabase("testdates");

        MongoCollection<Document> collection = database.getCollection("dts");
        collection.drop();
        List<Document> insertList = new ArrayList<Document>();
        Date date = new Date();
        Document document = new Document().
                append("_id", 20).append("date",date);
        insertList.add(document);
        collection.insertMany(insertList);
        System.out.println(collection.count());
        MongoCursor<Document> doc = collection.find(new Document("date", date)).iterator();
        System.out.println(doc.next().getDate("date"));
    }
}