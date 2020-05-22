bytes[] orig = <your byte array>;  
String prepend = "00";  
bytes[] prependBytes = prepend.getBytes();  
bytes[] output = new Bytes[prependBytes.length + orig.length];

for(i=0;i<prependBytes.length;i++){
    output[i] = prependBytes[i];
}

for(i=prependBytes.length;i<(orig.length+prepend.lenth);i++){
  output[i] = orig[i];
}