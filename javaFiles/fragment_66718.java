package com.service.mongo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import com.xp.util.Utils;

public class TestGenericService {

public static void main(String[] args) {
    //Start. This return a JSON string.
    String result =readQueryOfMongo("localhost","test","employeeCollection","Name,Empno,Dept:ABC",":",",","Empno","");
    System.out.println(result);
}


public static String readQueryOfMongo(  

        String serverNameUrl ,
        String dbName ,
        String collectionName,
        String fieldValuePair,
        String fVSeaprator,
        String vFSeaprator,
        String sortField,
        String sortDirection
)
{
    DB db;
    DBCollection table = null;
    DBCursor cursor = null;
    String result=null;
    BasicDBObject sortPredicate = new BasicDBObject();
    try
    {

        Map<String, String> fieldValuePairMap = new HashMap<String, String>();

        System.out.println("ServerName:"+serverNameUrl+"\nDatabase Name:"+dbName+"\nCollection Name:"+collectionName);

        //Configure the server, db and collection.
        MongoClient mongoClient = new MongoClient( serverNameUrl );

        db = mongoClient.getDB( dbName );

        System.out.println(db.getLastError());

        if (db.collectionExists(collectionName))
        {
            table = db.getCollection(collectionName);

        }
        else
        {
            throw new Exception("Collection doesn't exist");
        }

        //Define SortPredicate.
        if(sortField!= null)
        {
            if(sortDirection==null ||sortDirection.trim().length()==0)
                sortDirection="-1";//Default sort-order should be DESC.

            sortPredicate.put(sortField, Integer.parseInt(sortDirection));
        }

        if (null != fieldValuePair && fieldValuePair.trim().length() > 0)

        {
            BasicDBObject searchQuery = new BasicDBObject();

            fieldValuePairMap = parseStringToMap(fieldValuePair, fVSeaprator, vFSeaprator);

            System.out.println(fieldValuePairMap.size());

            BasicDBObject fields1 = new BasicDBObject("_id",false);


            if(fieldValuePairMap.size()>0)
            {
                Set keySet  = fieldValuePairMap.keySet();
                Iterator keyIter = keySet.iterator();
                String tempKey;
                while (keyIter.hasNext()) 
                {
                    tempKey = keyIter.next().toString();
                    fields1.append(tempKey, true);
                    if(fieldValuePairMap.get(tempKey)!=null)
                        searchQuery.put(tempKey, fieldValuePairMap.get(tempKey));
                }

                cursor = table.find(searchQuery,fields1).sort(sortPredicate);
            }

        }
        else
        {
            cursor = table.find().sort(sortPredicate);
        }
        result = parseStubJson(cursor, collectionName);

    }catch (Exception e) {
        e.printStackTrace();

    }
    return result;
}

public static String parseStubJson(DBCursor dBCursor, String stubName)
{
    System.out.println("Creating a JSON stub of:"+stubName);

    String response="{"+"\""+stubName+"\":[";
    int i=0;
    int j= dBCursor.count();
    while (dBCursor.hasNext()) 
    {
        i++;
        response += JSON.parse(dBCursor.next().toString());
        if(j>i)
            response +=",";
    }

    response += "]}";
    return response;
}

public static Map<String, String>  parseStringToMap(String kerValuePair,String seprator1,String seprator2)
{
    Map<String, String> myMap = new HashMap<String, String>();

    String[] pairs = kerValuePair.split(seprator2);
    for (int i=0;i<pairs.length;i++) {
        String pair = pairs[i];
        String[] keyValue = pair.split(seprator1);
        if(keyValue.length > 1)
            myMap.put(keyValue[0], keyValue[1]);
        else
            myMap.put(pairs[i], null);
    }

    Iterator itr = myMap.entrySet().iterator();
    while (itr.hasNext()) {
        Object object = (Object) itr.next();
        System.out.println(object.toString());
    }
    return myMap;
}