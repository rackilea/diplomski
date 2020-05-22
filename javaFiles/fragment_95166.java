public class SomeActivity extends Activity {

    private X x = new X();

    @Override protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AsyncTask<X, String, Long>() {

            @Override protected Long doInBackground(final X... params) {
                //  do something here
                return null;
            }

            @Override protected void onPostExecute(final Long result) {
                if (result == null) {
                    //  update args and restart task
                    x.setFoo("a");
                    x.setBar("b");
                    execute(x);
                }

            }
        }.execute(x);
    }

    private class X {
        String foo;
        String bar;

        public void setFoo(final String foo) {
            this.foo = foo;
        }

        public void setBar(final String bar) {
            this.bar = bar;
        }
    }
}