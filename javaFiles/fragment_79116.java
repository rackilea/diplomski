OutputStream os = response.getOutputStream();
os.write(239); //0xEF
os.write(187); //0xBB
os.write(191); //0xBF

// then write your data normally
OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");