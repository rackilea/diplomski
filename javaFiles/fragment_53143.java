String str = "[";
for(int i=0; i<arrayList.size(); i++){
  if(i == arrayList.size()-1){
      //Don't add comma at the end.
      str += arrayList.get(i);    
  }
  else{
      str += arrayList.get(i)+",";
  }
}
str += "]";