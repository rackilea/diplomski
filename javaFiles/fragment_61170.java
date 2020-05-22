public class UserFragment extends ListFragment {
      Context ctx;
      View v;
      Button mAddEntry;
      static int p; 
      static ArrayList<String> entryArray;
      static ArrayAdapter<String> a;

       @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ctx = container.getContext();
            if (v != null) 
                return v;

            v = inflater.inflate(R.layout.user_fragment, container, false);
            mAddEntry = (Button) v.findViewById(R.id.entry_b);
            mAddEntry.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle b = new Bundle();
                    b.putInt("pos", p);
                    Intent mi = new Intent(v.getContext(), EntryAdd.class);
                    mi.putExtras(b);
                    startActivity(mi);
                }
            });    
            updateUserFrag(p);
            return v;      
       }     

       public void updateUserFrag (int p) {        
             entryArray = new ArrayList<String>();
             a = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, entryArray);
             setListAdapter(a);
       }

       static Handler handy = new Handler() { 
            public void handleMessage(Message msg) { 
                int p = msg.getData().getInt("p"); 
                int m = msg.getData().getInt("m"); 
                ArrayList<String> e = msg.getData().getStringArrayList("e");

                switch (m) { 
                    case 0: 
                        Log.d("HANDLER", Integer.toString(p));
                        entryArray.clear();
                        for (int i=0;i<e.size();i++) {
                            entryArray.add(e.get(i));
                        }
                        a.notifyDataSetChanged();
                    break; 
                 } 
            } 
       };      
}