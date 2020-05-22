MainActivity extends AppCompatActivity implements Observer {
     public void onCreate(Bundle savedInstanceState)
     {
        // other onCreate stuff
        Singleton.getInstance().getUserInfo().addObserver(this);
        // UserInfo initialization
        ...
        // UI initialization
        Singleton.getInstance().getUserInfo().notifyObservers();
     }

     public void update(Observable observable, Object data)
     {
        if (observable instanceof UserInfo)
        {
           //update ui
        }
     }
 }