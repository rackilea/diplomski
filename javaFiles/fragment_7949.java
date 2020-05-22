get("/post/:id", (req, res ) -> {
        //what's the difference between these 2?
        res.raw().setContentType("video/mp4");
        res.type("video/mp4");

        String id = req.params(":id");

        ObjectId objectId = new ObjectId(id);
        BasicDBObject query = new BasicDBObject();

        query.put("_id", objectId);
        GridFS gridfile = new GridFS(db, "videos");
        GridFSDBFile gridFSDBFile = gridfile.findOne(query);

        res.raw().setContentLengthLong(gridFSDBFile.getLength());
        InputStream inputStream = gridFSDBFile.getInputStream();

        ServletOutputStream out = res.raw().getOutputStream();

        int data = inputStream.read();
        while (data >= 0) {
            gridFSDBFile.writeTo(out);
            data = inputStream.read();
        }

       // out.flush();
       out.close();

       return 200;

    });