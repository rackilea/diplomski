Gson gson = new GsonBuilder().serializeNulls().create();

  GoogleMapper mapper = gson.fromJson(page, GoogleMapper.class);

  List<Results> results = mapper.getResults();
  if(results != null){
    for(Results r : results){
     System.out.println("Fetched name: " + r.getName());
    }
  }