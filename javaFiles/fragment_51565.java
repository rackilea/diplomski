public void printNames(String query){
    if(query.length() < 3){
        // report an error, with an exception or print statement
        System.out.println("Search query must be at least 3 characters.");
    }
    for(Video v : videos){
        if(v.getName().startsWith(query)){
            v.printDetails();
        }
    }
}