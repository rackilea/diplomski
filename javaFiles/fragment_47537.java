class Bar extends AsyncTask<Void, Void, Result> {
     private final Foo foo;
     public Bar(Foo foo) { this.foo = foo; }

     public void onPostExecute(Result res) {
       foo.doSomething(res);
     }
}


class Foo {
   public void doSomething(Result res) {
      /// process result
   }

   public void startTask() {
       new Bar(this).execute();
   }
}