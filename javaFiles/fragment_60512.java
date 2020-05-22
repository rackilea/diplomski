private Handler handler = new Handler();

//TODO: don't call functions read1, write2 etc, call it something like "readSomeValue" where "SomeValue" is what you're trying to read
private void read1() throws IOException {
    String inpuRead = "2b 00 ff fe c7 80";  //This string is what I receive as an answer via bluetooth
    if (inpuRead != null) { //|| !inpuRead.equals("")) {
        int splitInt = splitReceivedString (inpuRead);
        receive1 = splitInt;
        Toast.makeText(getApplicationContext(), "Loading values", Toast.LENGTH_LONG).show();
    }
    else {
        throw new IOException("Error in read1");
    }
}

private void write2() {
    byte[] send2 = message_full2.getBytes();
    GlobalVar.mTransmission.write(send2);
}

private void read2() throws IOException {
    String inpuRead = "2b 00 ff fe c7 80";
    if (inpuRead != null) {
        int splitInt = splitReceivedString (inpuRead);
        receive2 = splitInt;
    }
    else {
        throw new IOException("Error in read2");
    }
}

public void receiveValues() {
    handler.post(new Runnable() {
        @Override
        public void run() {
            try {
                read1();
                read2();
                read3();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "Communication error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    });
}