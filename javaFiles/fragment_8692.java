new Thread(new Runnable() {
    public void run()
    {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=10; i++)
        {
            sb.append("Running iteration " + i + "\n");
            final String result = sb.toString();

            Display.getDisplay().asyncExec(new Runnable() {
                public void run()
                {
                    txtLogBox.setText(result);
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}).start();