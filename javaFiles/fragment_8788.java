public class MyActivity extends Activity{

            private TextView nameTextView ;
            private Subscription subs;
            @Override
            public void onCreate{
            //initialization of fields
            }

            @Override
            public void onResume(){
              super.onResume();
              subs = User.getInstance().stream.subscribe{user-> nameTextView.setText(user.username) }
          }

             @Override
             public void onPause(){
             super.onPause();
             subs.unsubscribe();
             }
    }