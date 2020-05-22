public class SomeActivity extends AppCompatActivity {
    PedidosAdapter pedidosAdapter;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.some_view);
        pedidosAdapter = new PedidosAdapter(context, mRepositorio.findAllPedidos());
        // set adapter, ...
    }
}