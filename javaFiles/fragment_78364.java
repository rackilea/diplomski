@Override
public void onCreate(Bundle savedInstanceState) {


    super.onCreate(savedInstanceState);
    // TODO Auto-generated method stub
    setContentView(R.layout.fragment_cliente);

    getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setHomeButtonEnabled(true);

    SecurePreferences mSessao = new SecurePreferences(FragmentClientes.this, "sessao");
    mSessao.put("menuAtual", "Clientes");

    Integer idViagem = getIntent().getIntExtra(TAG, -1);

    init(idViagem);



}


public void init(Integer mId)  {

    clientes = new ArrayList<ClienteModel>();


    try {

        mRepositorio = new Repositorio(FragmentClientes.this);

        List lista = mRepositorio.getClientesViagem(mId);

        clientes = lista;


        ad = new ClientViewAdapter(FragmentClientes.this, this, clientes);



        lv.setVerticalFadingEdgeEnabled(true);
        lv.setVerticalScrollBarEnabled(true);


        lv.setAdapter(ad);



    } catch (Exception e) {
        e.printStackTrace();
    }


}