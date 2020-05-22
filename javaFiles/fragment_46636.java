System.out.println("output="+output);  
String[] output2= output.split(",");   

for (String member : output2) {
    String[] output3= member.split("/");

    for (String str : output3) {
      System.out.println (str);
    }

    // or just the last one

    System.out.println (output3[output3.length - 1]);
}