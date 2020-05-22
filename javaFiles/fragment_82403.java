Thread thread = new Thread()
{

    @Override
    public void run() {
        try {
            if(true) {
                sleep(1000);
                String txt = handler.post("http://www.golftipp.com/pruebas_android/app.php");
                TextView t = (TextView) findViewById(R.id.textView2);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // do UI updates here
                        t.setText(txt);
                    }
                });

                System.out.println(txt);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

};
thread.start();