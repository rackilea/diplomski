MediaScannerConnection.scanFile(GameView.this, new String[] {Environment.getExternalStorageDirectory().toString()+"/Statbook CSV Files/"+game+".csv"}, null, new MediaScannerConnection.OnScanCompletedListener() {

                    @Override
                    public void onScanCompleted(String arg0, Uri arg1) {
                        // TODO Auto-generated method stub
                        Log.i("External Storage", "Scanned " + arg0 + ":" + "-> uri=" + arg1);
                }