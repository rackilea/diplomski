public void updateData(int dataType, Data data){
   // store new data
   if (dataType == DATA_TAX_RATE){
       this.taxRate = data.getValue();
   }

   .....

   // then iterate through listeners and send updated data to them
   for (Updateable listener : listeners){
       try {
          listener.onUpdate(dataType, data);
       } catch (Throwable e) {}
   } 
}