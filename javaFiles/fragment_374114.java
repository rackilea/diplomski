public class MainActivity extends Activity{

    ActivityMainBinding binding; //Name of the layout in camel case + "Binding"

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvTest.setLayoutManager(layoutManager);

        List<String> items = Arrays.asList("item", "item", "item");

        binding.rvTest.setAdapter(new MyAdapter(items));
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        private List<String> items;

        private class MyViewHolder extends RecyclerView.ViewHolder{

            TestListItemBinding binding;//Name of the test_list_item.xml in camel case + "Binding"

            public MyViewHolder(TestListItemBinding b){
                super(b.getRoot());
                binding = b;
            }
        }

        public MyAdapter(List<String> items){
            this.items = items;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            return new MyViewHolder(TestListItemBinding.inflate(getLayoutInflater()));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position){
            String text = String.format(Locale.ENGLISH, "%s %d", items.get(position), position);

            //An example of how to use the bindings
            holder.binding.tvTest.setText(text);
        }

        @Override
        public int getItemCount(){
            return items.size();
        }
    }

}