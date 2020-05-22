FileInputStream fIn = openFileInput("txt");
InputStreamReader isr = new InputStreamReader(fIn);
StringBuffer fileContent = new StringBuffer("");

char[] buffer = new char[1024];
int len;
while ((len = isr.read(buffer, 0, 1024)) != -1) {
    fileContent.append(new String(buffer, 0, len));
}

String data = fileContent.toString();
//be sure to call isr.close() and fIn.close()