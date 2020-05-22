try {

            //-----creating a parent folder
            System.out.println("Creating a test folder...");
            JsonObject newTF = new JsonObject();
            newTF.addProperty("Name", "parent tf via java");
            newTF.addProperty("Project", projectRef); 


            CreateRequest createRequest = new CreateRequest("testfolder", newTF);
            CreateResponse createResponse = restApi.create(createRequest);  
            if (createResponse.wasSuccessful()) {

                System.out.println(String.format("Created %s", createResponse.getObject().get("_ref").getAsString()));          

                //Read test folder
                String folderRef = Ref.getRelativeRef(createResponse.getObject().get("_ref").getAsString());
                System.out.println(String.format("\nReading TestFolder %s...",folderRef));
                System.out.println("Creating a child test folder...");
                JsonObject newChildTF = new JsonObject();
                newChildTF.addProperty("Name", "child tf via java");
                newChildTF.addProperty("Project", projectRef); 
                newChildTF.addProperty("Parent", folderRef); 


                CreateRequest createRequest2 = new CreateRequest("testfolder", newChildTF);
                CreateResponse createResponse2 = restApi.create(createRequest2); 
                if (createResponse2.wasSuccessful()) {
                    //----------------creating a grandchild folder  
                    System.out.println(String.format("Created %s", createResponse2.getObject().get("_ref").getAsString()));          

                    //Read test folder
                    String childFolderRef = Ref.getRelativeRef(createResponse2.getObject().get("_ref").getAsString());
                    System.out.println(String.format("\nReading TestFolder %s...",childFolderRef)); 
                    System.out.println("Creating a grandchild test folder...");
                    JsonObject newGrandChildTF = new JsonObject();
                    newGrandChildTF.addProperty("Name", "grandchild tf via java");
                    newGrandChildTF.addProperty("Project", projectRef); 
                    newGrandChildTF.addProperty("Parent", childFolderRef); 


                    CreateRequest createRequest3 = new CreateRequest("testfolder", newGrandChildTF);
                    CreateResponse createResponse3 = restApi.create(createRequest3); 
                    //----------------creating a test case
                    if (createResponse.wasSuccessful()) {

                        System.out.println(String.format("Created %s", createResponse.getObject().get("_ref").getAsString()));          

                        //Read test folder
                        String grandChildFolderRef = Ref.getRelativeRef(createResponse3.getObject().get("_ref").getAsString());
                        System.out.println(String.format("\nReading Child TestFolder %s...",grandChildFolderRef));

                        System.out.println("Creating a test case...");
                        JsonObject newTC = new JsonObject();
                        newTC.addProperty("Name", "tc via java");
                        newTC.addProperty("Project", projectRef); 
                        newTC.addProperty("TestFolder", grandChildFolderRef);
                        newTC.addProperty("Method", "Manual");


                        CreateRequest createRequest4 = new CreateRequest("testcase", newTC);
                        CreateResponse createResponse4 = restApi.create(createRequest4); 
                        if (createResponse.wasSuccessful()) {

                            System.out.println(String.format("Created %s", createResponse4.getObject().get("_ref").getAsString()));          

                            //Read test folder
                            String testCaseRef = Ref.getRelativeRef(createResponse4.getObject().get("_ref").getAsString());
                            System.out.println(String.format("\nReading TestCase %s...",testCaseRef));
                        }

                    }
                }



            } else {
                String[] createErrors;
                createErrors = createResponse.getErrors();
                System.out.println("Error!");
                for (int j=0; j<createErrors.length;j++) {
                    System.out.println(createErrors[j]);
                }
            }


    } finally {
        //Release all resources
        restApi.close();
    }