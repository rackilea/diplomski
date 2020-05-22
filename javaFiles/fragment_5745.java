try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("updating...", "");
                            Notifydatasetchanged()
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }