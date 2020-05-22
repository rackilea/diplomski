String text = ""; 
for(int i = 0; i < actors.size(); i++){
   text = text + actors.get(i);
   if(i < actors.size() - 2){
        text = text + ", ";   
   }
} 
CastLabel1.setText(text);