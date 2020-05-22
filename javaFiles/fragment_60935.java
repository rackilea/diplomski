File F = //Some file here (Less than 2 GB please)
FileInputStream fIn = new FileInputStream(F);
ByteArrayOutputStream bOut = new ByteArrayOutputStream(((int)F.length()) + 1);

int r;
byte[] buf = new byte[32 * 1000];

while((r = fIn.read(buf) != -1){
    bOut.write(buf, 0, r);
}

//Do a memory measurement at this point. You'll see your using nearly 3x the memory in RAM compared to the file.
//If your actually gonna try this, remember to surround with try-catch and close the streams as appropriate.