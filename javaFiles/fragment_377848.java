package com.softlayer.objectstorage.main;

import java.util.HashMap;
import java.util.Map;
import com.softlayer.objectstorage.Container;
import com.softlayer.objectstorage.ObjectFile;


public class ObjectStorage {
    String baseUrl;
    String user;
    String password;

    public ObjectStorage(String baseUrl, String user, String password){
        this.baseUrl = baseUrl;
        this.user = user;
        this.password = password;
    }

    public void createContainer(String containerName){

        try{
            Container containerCreate = new Container(containerName, baseUrl, user,
                    password, true);
            containerCreate.create();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void UploadFile(String containerName, String fileName, String path)
    {
        try{
            ObjectFile oFile = new ObjectFile(fileName, containerName, baseUrl, user, password, true);
            Map<String, String> tags = new HashMap<String, String>();
            tags.put("testtag", "Test Value");
            String newOb = oFile.uploadFile(path, tags);
        }catch (Exception e)
        {
            System.out.println(e);
        }


    }

    public static void main(String[] args) {

        /**
         * Define Object Storage's parameters
         */
        String baseUrl = "https://dal05.objectstorage.softlayer.net/auth/v1.0/";
        String user = "set me";
        String password = "set me";

        // Define the container name to create
        String containerName = "containerTest";
        // Define the file name to create in the object storage
        String fileName = "newTest.txt";
        // Define the location path from file that you wish to upload
        String pathFile = "C:\\Users\\Ruber Cuellar\\Documents\\test.txt";

        // Create Object Storage connection
        ObjectStorage objectStorage = new ObjectStorage(baseUrl, user, password);
        // Create Container
        objectStorage.createContainer(containerName);
        // Upload file
        objectStorage.UploadFile(containerName, fileName, pathFile);

    }
}