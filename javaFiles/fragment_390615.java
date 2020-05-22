fw = new FileWriter(new File(Environment.getExternalStorageDirectory().getPath()
           + "/myFolder/public.key"));
...
while(something){
    fw.write(blaBla);
}
fw.flush();
fw.close();