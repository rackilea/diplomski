String response = "Hello, World";
String[] words = response.split(" ");
TextView tv1 = (TextView) findViewById(R.id....);
TextView tv2 = (TextView) findViewById(R.id....);
tv1.setText(words[0]);
tv2.setText(words[1]);