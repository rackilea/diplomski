private Handler read1_handler = new Handler();
private Handler write2_handler = new Handler();
private Handler read2_handler = new Handler();

public void receiveValues() {
  /**Delay to wait until it receives the answer to the petition above*/
    read1_handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            String inpuRead = "2b 00 ff fe c7 80";  //This string is what I receive as an answer via bluetooth
            if (inpuRead != null) { //|| !inpuRead.equals("")) {
                int splitInt = splitReceivedString (inpuRead);
                receive1 = splitInt;
                Toast.makeText(getApplicationContext(), "Loading values", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Communication error", Toast.LENGTH_SHORT).show();
            }
        }
    }, 1000);

    /**Delay to wait to send de second petition string*/
    write2_handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            byte[] send2 = message_full2.getBytes();
            GlobalVar.mTransmission.write(send2);
        }
    }, 2000);

    /**Delay to wait until it receives the answer to the second petition string*/
    read2_handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            String inpuRead = "2b 00 ff fe c7 80";
            if (inpuRead != null) {
                int splitInt = splitReceivedString (inpuRead);
                receive2 = splitInt;
            }
            else {
                Toast.makeText(getApplicationContext(), Communication error, Toast.LENGTH_SHORT).show();
            }
        }
    }, 3000);
}