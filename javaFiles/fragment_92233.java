public void onClick(View v) {
    if (v.getId()==R.id.button5){
        Intent i = new Intent(this, Tokenizing.class);

        String test = ((TextView)findViewById(R.id.textView6)).getText().toString();
        test = test.toLowerCase();
        test = test.replaceAll("\\W", " ");
        StringBuilder result = new StringBuilder();
        StringTokenizer st2 = new StringTokenizer(test);
        int len=st2.countTokens();
        System.out.println(len);
        result.append(len+"\n");
            while (st2.hasMoreTokens()) {
                String st3 = st2.nextToken();
                System.out.println(st3);
                result.append(st3+'\n');
        }

        i.putExtra("result", result.toString());
        startActivity(i);
        //Log.i("Test Klik Next", result);
    }