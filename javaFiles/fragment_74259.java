String[] lines1 = sb.toString().split("\\n");
StringBuilder temp = new StringBuilder();
for(String getVal: lines1){
 if(getVal.startsWith("6000")){
     temp.append(getVal);
     break;
 }
 else{
     temp.append(getVal);
 }
 temp.append("\n");
}