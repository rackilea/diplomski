MyActivity.this.runOnUiThread(new Runnable() {
            @Override
            void run() {
               Toast.makeText(MyActivity.this,
                    "message", Toast.LENGTH_LONG).show();
            });