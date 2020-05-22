String filePath = context.getFilesDir() + File.separator + "my_turtle.ttl";
    File destinationFile = new File(filePath);
    FileOutputStream outputStream = new FileOutputStream(destinationFile);
    AssetManager assetManager = context.getAssets();
    InputStream inputStream = assetManager.open("sample_3.ttl");
    byte[] buffer = new byte[1024];
    int length = 0;
    while((length = inputStream.read(buffer)) != -1){
        outputStream.write(buffer,0,length);
    }
    inputStream.close();
    outputStream.close();



    Model model = null;

    model = FileManager.get().loadModel(filePath,"TTL");

    Query query = QueryFactory.create(stringQuery);

    QueryExecution qexec = QueryExecutionFactory.create(query, model);
    ResultSet results = qexec.execSelect();
    while(results.hasNext()) {
            QuerySolution soln = results.nextSolution();
            Literal answerLiteral = soln.getLiteral("abstract");
            answer = answerLiteral.toString();
            System.out.println(answer);


        }



    if(!answer.equals("")){
        this.answer = answer;
        return answer;
    }
    else{
        return "I could not find an answer";
    }