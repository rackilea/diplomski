class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    interface OnClickListener {
        void onClick(Item item);
    }

    private final List<Item> dataset;
    private final OnClickListener l; 

    public MyAdapter(List<Item> data, OnClickListener listener) {
        this.dataset = data;
        this.l = listener;
    }

    @Override MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = //inflate layout
        MyClick click = new MyClick() {
            onClick(int position) {
                if (l != null) {
                    l.onClick(dataset.get(position));
                }
            }
        };
        return new MyViewHolder(click, v);
    }

    static class MyViewHolder {
        final MyClick l;

        public MyViewHolder(MyClick listener, View view) {
            super(view);
            l = listener;
            // inflate views
            view.setOnClickListener(new OnClickListener() {
                if (l != null) {
                    l.onClick(getAdapterPosition());
                }
            });
        }

        interface MyClick {
            void onClick(int position);
        }
    }
}

class MyActivity extends AppCompatActivity {

    @Override void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set layout
        MyAdapter adapter = new MyAdapter(getData(), new OnClickListener() {
            @Override onClick(Item item) {
                // do stuff with item
            }
        });
    }
}