try {
  Process process = Runtime.getRuntime().exec("ls");
  BufferedReader bufferedReader = new BufferedReader(
  new InputStreamReader(process.getInputStream()));

  StringBuilder result=new StringBuilder();
  String line = "";
  while ((line = bufferedReader.readLine()) != null) {
    result.append(line);
  }
  TextView tv = (TextView)findViewById(R.id.textView1);
  tv.setText(result.toString());
  } 
catch (IOException e) {}