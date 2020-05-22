InputStream is = bodyPart.getInputStream();
InputStreamReader sin = new InputStreamReader(is, 
                                              "UTF8"); // <-- attachment charset 

File f = new File(bodyPart.getFileName());
OutputStreamWriter sout = new OutputStreamWriter(new FileOutputStream(f), "UTF8");
BufferedReader buff_in = new BufferedReader(sin);
BufferedWriter buff_out = new BufferedWriter(sout);

int charRead;
while ((charRead = buff_in.read()) != -1) {
    buff_out.write(charRead);
}

buff_in.close();
buff_out.close();