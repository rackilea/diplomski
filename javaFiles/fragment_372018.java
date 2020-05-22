for(Object obj : itemsList) {

    if(obj instanceof List) {    //if it is List type then type cast it

          List<String> str = (List<String>) obj;
          for(String s : str) {

             System.out.println(s);

                  }
          }
    }