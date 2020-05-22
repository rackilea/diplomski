String lineIndex="21";
String line="2";
String currentBid="102";

File temp = File.createTempFile("temp-sh", ".sh"); 



FileWriter fw = new FileWriter(temp);
fw.write("#!/bin/bash\n");
fw.write("sed -i '"+lineIndex+"s/"+line+"/"+currentBid+"/g' data/jsp/items.xml\n");
fw.close();
System.out.println(". "+temp.getAbsolutePath());
Runtime.getRuntime().exec(". "+temp.getAbsolutePath());