Yo can also use 

runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text22.setText(hey);
                            }
                        });

It will give you main thread access to render on UI.