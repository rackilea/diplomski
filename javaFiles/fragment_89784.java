public void method(Object object){
        if(object instanceof byte[]){ //check if object is of type byte[]
            byte[] bytes=(byte[]) object;//cast it as byte[]
            //work with byte[]
        }
        else if(object instanceof Byte[]){
            Byte[] bytes=(Byte[]) object;
            //work with Byte[]
        }
        else{
            //the object is neither byte[] or Byte[]
        }
    }