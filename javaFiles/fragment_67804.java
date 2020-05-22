String mystring = new String();   // an empty string

    GridFS gridFS = new GridFS(mongoTemplate.getDB(),"noteAndFile");
    GridFSInputFile gfsFile = gridFS.createFile(
        new ByteArrayInputStream( mystring.getBytes() )
    );

    BasicDBObject meta = new BasicDBObject();
    meta.put("comments","hi");

    gfsFile.put("metadata",meta);
    gfsFile.save();

    System.out.println(gfsFile.getId());    // gives me the _id of the object saved