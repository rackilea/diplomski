List<String> inc = dh.selectInct1();
List<String> inc2 = dh.selectInct2();  //select your data to second list
inc.addAll(inc2); // join them together
ArrayAdapter<String> inc1 = new ArrayAdapter<String>(this,R.layout.list,R.id.textViewx,inc);
lvinc.setAdapter(inc1);
lvinc.setOnItemClickListener(this);