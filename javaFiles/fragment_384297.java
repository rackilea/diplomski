onPostExecute(){
            isCompleted = true 
            ....
            ...
            ...             
        }

    public void anotherMethod(){
       while(isCompleted){
        //operations
       }
   }