if(images.size() > 0){
      for (Element src : images){
          if (src != null) {
             System.out.println("Source " + src.attr("abs:src"));
          }
      }
  } else {
      System.out.println("There are no elements in ArrayList<> images");
  }