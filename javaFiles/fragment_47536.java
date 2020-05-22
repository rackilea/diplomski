class Foo {
   class Bar extends AsyncTask<Void, Void, Result> {

      public void onPostExecute(Result res) {
         doSomething(res);
      }
   }

   public void doSomething(Result res) {
      /// process result
   }

   public void startTask() {
       new Bar().execute();
   }
}