// Call the layout inflater first
View view = inflater.inflate(R.layout.fragment_main, container, false);
// Initialize your views
ListView listView = (ListView) view.findViewById(R.id.listView_Forecast);
listView.setAdapter(adapter);

// Do the rest of your code
...
return view;