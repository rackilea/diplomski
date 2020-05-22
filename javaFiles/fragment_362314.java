try {
    String temp;
    InputStream fis = game.getFileIO().readFile("AFC/save.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    if((temp = br.readLine()) != null)
    {
          player = temp;
          Log.d("File", "Value : " + player );
    }
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}