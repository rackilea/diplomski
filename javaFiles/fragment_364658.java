protected void onPostExecute(List<Photoshoots> result) {
                super.onPostExecute(result);



                if (result != null) {
    PhotoshootAdapter adapter = new PhotoshootAdapter(getApplicationContext(), R.layout.row, result);
                    lvPhotoshoots.setAdapter(adapter);}

else{
    new CountDownTimer(60000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            btnRefresh.setText("No Data to Show. Try again in " + millisUntilFinished / 1000 + " Seconds");
                        }

                        public void onFinish() {
                            btnRefresh.setText("Refresh");
                            btnRefresh.setEnabled(true);
                        }
                    }.start();