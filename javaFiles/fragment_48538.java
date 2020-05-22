String line = "43.0 0.0 0.0 0.0";
    String[]columns = line.split("\t");
    String output1 = "";
    String output2 = "";
    String output3 = "";
    String output4 = "";

    System.out.println(columns.length);

    for(int i=0;i<4;i++) {
        if(i<columns.length) {
           switch(i) {
              case 0:  output1 = columns[0];
                       break;
              case 1:  output2 = columns[1];
                       break;
              case 2:  output3 = columns[2];
                     break;
              case 3:  output4 = columns[3];
                     break;
           }
        }
    }

    System.out.println("1: "+output1);
    System.out.println("2: "+output2);
    System.out.println("3: "+output3);
    System.out.println("4: "+output4);