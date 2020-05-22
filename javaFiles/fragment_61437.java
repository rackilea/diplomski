List<ChatWrapper> messages;
List<ImageDataWrapper> images;
ChatAdapter adapter;

@Override
public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    messages = new ArrayList<>();
    images = new ArrayList<>();
    ChatAdapter adapter = new ChatAdapter(this, messages, images);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
}

public void addMessage(ChatWrapper message){
    messages.add(message);
    adapter.notifyDataSetChanged();
}

public void removeMessage(ChatWrapper message){
    if(messages.remove(message)){
        adapter.notifyDataSetChanged();
    }
}

public void addImage(ImageDataWrapper image){
    images.add(image);
    adapter.notifyDataSetChanged();
}

public void removeImage(ImageDataWrapper image){
    if(images.remove(image)){
        adapter.notifyDataSetChanged();
    }
}