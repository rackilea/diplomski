public void Test(){
   try{
     String[] x = ImageUtility.savePicture(getActivity(), bitmap);
     if(x != null && x.Length >= 1){
       value_one= x[0]; 
       value_two= x[1];
     }
   }catch(NullPointerException e){
     //print log
   }
 }