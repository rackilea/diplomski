public class LoginFragment extends Fragment {

    private AtomicInteger counter = new AtomicInteger();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //CONNECT TO INTERNET!!
                task=new PasswordCheckTask();
                task.execute();
                //END CONNECT TO INTERNET!!
            }
        });
   }

   class PasswordCheckTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void result) {

            if (success == "1"){
                 Intent xx = new Intent(getContext().getApplicationContext(), ArduinoFirst.class);
                 xx.putExtra("position", position);
                 startActivity(xx);
                 counter.set(3);
            } else if (counter.get() != 0) {
                 counter.getAndDecrement();
            }
       }
 }