File file = new File(myContext.getExternalFilesDir(null), "state.txt");
try {

     FileOutputStream os = new FileOutputStream(file, true); 
     OutputStreamWriter out = new OutputStreamWriter(os);
         out.write(data);
     out.close();
}