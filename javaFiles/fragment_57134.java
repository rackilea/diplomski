public class MainActivity extends AppCompatActivity implements OnImageClickListener   {
public ImageView idImgHead;
private ArrayList<Items> items;
private RecyclerView idRecyclerView;
private RecyclerView.Adapter adapter;
private RecyclerView.LayoutManager layoutManager;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    idRecyclerView = findViewById(R.id.idRecyclerView);
    idImgHead = findViewById(R.id.idImgHead);
    Glide.with(this).load("https://www.midominio.com/Imagen_GRANDE_head_01.jpg").into(idImgHead); //IMAGE BIG
    listadoXhead();
}

@Override
public onSelected(String url) {
     Glide.with(this).load(url).into(idImgHead);
}

private void listadoXhead() {
    ArrayList<Items> items = new ArrayList<>();
    items.add(new Items("https://www.midominio.com/Imagen_Pequeña_head_01.jpg")); //IMAGE Small
    items.add(new Items("https://www.midominio.com/Imagen_Pequeña_head_02.jpg")); //IMAGE Small
    items.add(new Items("https://www.midominio.com/Imagen_Pequeña_head_03.jpg")); //IMAGE Small
    idRecyclerView.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(MainActivity.this);
    ((LinearLayoutManager) layoutManager).setOrientation(RecyclerView.HORIZONTAL);
    adapter = new AdaptadorX(items, MainActivity.this, this);
    idRecyclerView.setLayoutManager(layoutManager);
    idRecyclerView.setAdapter(adapter);
}