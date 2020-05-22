View v = inflater.inflate(R.layout.two_fragment, container, false);
tv  = (TextView) v.findViewById(R.id.tv_two_fragment);
ls  = new LocationService(getActivity());
s   = ls.getLocation().getLatitude();
g   = Double.toString(s);
tv.setText(g);