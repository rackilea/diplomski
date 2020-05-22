YourActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    Toast toast = Toast.makeText(YourActivity.this, R.string.toast_parse_fail, Toast.LENGTH_LONG);
        toast.show();
                }
            });