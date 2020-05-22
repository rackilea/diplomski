List<String> result; 
try( Stream<Path> walk = Files.walk(Paths.get("data"))){
    result = walk.filter(Files::isRegularFile)
            .map(x -> x.toString()).collect(Collectors.toList());
}
catch(Exception e){
    e.printStackTrace();
    result = null;
}