String data1 = "Model1, 54321, Test, Online";
String data2 = "Model2, 12345, Check, OFF";

String output = (data1.split(", ")[3].equalsIgnoreCase("Online") && 
                 data2.split(", ")[3].equalsIgnoreCase("OL")) ? 
                 "Equal" :
                 "Not Equal";

System.out.println(output);