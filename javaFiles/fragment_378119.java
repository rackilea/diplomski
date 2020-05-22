Intent intent= new Intent(Activity1.this, Activity2.class);

ArrayList<String> fragArrayList= new ArrayList<>();

fragArrayList.add(String.valueOf(frag1.class.getName()));
fragArrayList.add(String.valueOf(frag2.class.getName()));
fragArrayList.add(String.valueOf(frag3.class.getName()));
fragArrayList.add(String.valueOf(frag4.class.getName()));
fragArrayList.add(String.valueOf(frag5.class.getName()));

intent.putExtra("fragArrayList"), fragArrayList);