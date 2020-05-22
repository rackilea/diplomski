StringBuilder sb = new StringBuilder(); 
 k=0; 
 byte[] writeBuffer = new byte[8];

 for (int value : lst) { 
 if(k==8) { k=0; sb.setLength(0); 
 } 
 sb.append(String.format("%02x ", value)); 

 writeBuffer[k] = (byte) value; k++; 
 }

 editSent.setText(sb.toString().toUpperCase());