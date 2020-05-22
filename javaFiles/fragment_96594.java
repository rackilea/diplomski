class AnkoComponentActivity : AppCompatActivity(){//Can be a regular Activity too

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        val component = intent.getSerializableExtra("uiComponent") as AnkoComponent<AnkoComponentActivity>//The type has to match this activity, or setContentView won't allow passing `this`
        component.setContentView(this)//The context of the activity doesn't get passed until this point, which enables the use of this system. 
    }
}