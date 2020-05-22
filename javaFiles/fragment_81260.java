public void readExternal(ObjectInput in) throws IOException,  
         ClassNotFoundException {  
             _query=(String) in.readObject();  
            if(//yourCondition){
             _resultSet=(CachedRowSetImpl) in.readObject();  
            }
         }