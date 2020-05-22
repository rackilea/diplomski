public class ContatosView extends MainActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contatos_view);

        Intent in = getIntent();

        // Get JSON values from previous intent
        String name = in.getStringExtra("endereco");


        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.txtNome);


        lblName.setText(name);



    }


}