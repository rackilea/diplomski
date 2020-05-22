StringBuilder sb = new StringBuilder();
for(int i=0; i<str.length; i++){
  if(i==str.length-1 || i==0){
    sb.append(str[i]);
  }else{
    sb.append(" "+str[i]);
  }
}