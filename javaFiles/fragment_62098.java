String info="asdf:0123-456-789:USB0::0x1234::0x9ABC::0123-456-789::INSTR";
String[] array=info.split(":", 3);//split only in 3 parts

System.out.println("name="+array[0]);
System.out.println("serial="+array[1]);
System.out.println("addr="+array[2]);