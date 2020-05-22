String string = "Fridays7/4/2017d12:50d13:50dTestd";
          String[] lineSplit1 = string.split("¬");
          for(String s: lineSplit1){
              System.out.println(s);
              System.out.println(lineSplit1.length);
              String day1 = lineSplit1[0];
                String date1 = lineSplit1[1];
                System.out.println(day1+""+date1);
          }
    }