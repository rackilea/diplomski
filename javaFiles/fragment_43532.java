public String getOutput() {
        mExecute();
        Log.d("xoutputD2", output + "");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return output;
    }