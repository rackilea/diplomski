StringBuilder sb = new StringBuilder();
sb.append("/bin/bash -l -c");
sb.append("\""+csi_path+pre_hash+post_hash+"\"");// add whitespace between the varaible, if required.
System.outprintln(sb.toString());  //verify your command here

csi.add(sb.toString());