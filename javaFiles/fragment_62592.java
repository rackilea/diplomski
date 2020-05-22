class ProcedureWithParams<T> extends Procedure<T> {
   Object param1;
   Object param2;

   ProcedureWithParams(Object param1, Object param2) {
      this.param1 = param1;
      this.param2 = param2;
   }

   public void apply(Object param) throws Exception {
    //access para1 and param2 here
   }

}

getContext().become( new ProcedureWithParams(param1, param2))