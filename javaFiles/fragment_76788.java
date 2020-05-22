@Override
public View getView(int position, View convertView, ViewGroup parent) {
    HelloCanvas hello = (HelloCanvas) convertView;
    if (hello == null) {
        // inflate a new view
        hello = (HelloCanvas) 
          LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
    }
    hello.setHelloString(getItem(position));
    return hello;
}