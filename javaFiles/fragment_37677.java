FileVisitor<Path> fv2=new LambdaFileVisitor<Path>()
  .onPreVisitDir((f,a)->{System.out.println("ENTER "+f); return CONTINUE; })
  .onPostVisitDir((f,e)->{
      System.out.println("LEAVE "+f);
      if(e!=null) throw e; else return CONTINUE;
  });