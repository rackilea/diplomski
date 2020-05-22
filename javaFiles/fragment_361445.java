package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class CognitoSaveUser {


    public Boolean saveNewUserInDB (RegistrationRequest jsonUserDetails,Context context) {

        Boolean processStatus = false;
        context.getLogger().log("Inside the method saveNewUserInDB");
        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonString = mapper.writeValueAsString(jsonUserDetails);
            context.getLogger().log("Converted JSOn String->"+jsonString);

            JsonFactory factory = new JsonFactory();
            JsonParser  parser  = factory.createParser(jsonString);

            Document doc = new Document();
            String docKey = "";
            String docValue = "";

            while(!parser.isClosed()){
                JsonToken jsonToken = parser.nextToken();

                if(JsonToken.FIELD_NAME.equals(jsonToken)){
                    docKey = parser.getCurrentName();
                    jsonToken = parser.nextToken();
                    docValue = parser.getValueAsString();
                    doc.append(docKey, docValue);
                    context.getLogger().log("Key->"+docKey+"-value->"+docValue);
                    } 
                }

            MongoClientURI uri = new MongoClientURI(
                       "mongodb+srv://username:password@clusterdemo-07d17.mongodb.net/dbname");
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("EclipseCognitoTest");
            MongoCollection<Document> collection = database.getCollection("UserProfile");

            context.getLogger().log("DB Connection is OK");
            collection.insertOne(doc);

            processStatus = true;
            context.getLogger().log("processStatus="+processStatus);

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return processStatus;
    }


}