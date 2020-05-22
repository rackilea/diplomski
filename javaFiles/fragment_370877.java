public void cycle(ListStore<String> line_data){

    List<String> lineListData = line_data.getAll();

    //for(LineObject line: lineListData){ <-- won't work since you are using Strings

    for(String line: lineListData){ // <-- this will work but probably not what you want
          //Other code goes here
    }

}