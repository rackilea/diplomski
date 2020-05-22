@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  View v = inflater.inflate(R.layout.alphabet, container, false);
  TextView tv = (TextView)v.findViewById(R.id.alphabet);
  ImageView iv = (ImageView)v.findViewById(R.id.letter);
  iv.setImageResource(getArguments().getInt("letter")); // maybe check first if the argument is set :)
  tv.setText(getArguments().getString("msg"));

  return v;
}