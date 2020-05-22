public String withoutString(String base, String remove){ 
  String result = base.replaceAll("(?i)" + remove, "");

  for(int i = 0; i < result.length()-1;){
    if(result.substring(i,i+2).equals("  ")){
      result = result.replace(result.substring(i,i+2), " ");
    }
    else i++;
  }

  if(result.startsWith(" ")) result = result.substring(1);
  return result;
}