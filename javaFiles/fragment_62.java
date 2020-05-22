class DataObjImpl {

   private Object data;

   public Object getData() {
      return data;
   }

   public void setData(Object data) {
      this.data = data;
   }

   public DataObjImpl(DataObjImpl obj) {
      this.data = obj.data;
   }        
}