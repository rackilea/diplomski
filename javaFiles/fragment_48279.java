private void btRunConfiguration(ActionEvent evt) {
        getContentPane().removeAll();
        getContentPane().add( topPanel );
        getContentPane().repaint();

        setTitle("Simple Table Application");
        setSize(300, 100);
        setBackground(Color.gray);
        pack();
        showOnScreen(1,this);
        setVisible(true);
        final AtomicBoolean flag = new AtomicBoolean(false);
        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!flag.get()){
                    flag.set(true);
                    new MyWorker(flag).execute();
                    //flag.set(false);
                }
            }
        };
        Timer timer = new Timer(20, taskPerformer);
        timer.setRepeats(true);
        timer.start();

    }
    class MyWorker extends SwingWorker<Void, Void> {

        AtomicBoolean flag;
        MyWorker(AtomicBoolean flag){
            this.flag=flag;
        }

        @Override
        public Void doInBackground() {

            for (int i = 0; i < 300; i++) {
                try {
                    Runtime rt = Runtime.getRuntime();
                    String url = "http://stackoverflow.com";
                    rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    // ignore!
                    ie.printStackTrace();
                } catch (Exception le) {
                    le.printStackTrace();
                }
                model.addRow(new Object[]{i, i, i});
                /**************This message dialog box show row updated to refresh table for viewing***********/
                //Must schedule the close before the dialog becomes visible
                JFrame closeDialog = new JFrame();
                final JDialog dialog = new JDialog(closeDialog, "Updated", true);

                ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
                s.schedule(new Runnable() {
                    public void run() {
                        dialog.setVisible(false); //should be invoked on the EDT
                        dialog.dispose();
                    }
                }, 500, TimeUnit.MILLISECONDS);

                dialog.setVisible(true); // if modal, application will pause here

                //System.out.println("Dialog closed");
                /**************This message dialog box show row updated to refresh table for viewing***********/

            }
            return null;
        }

        @Override
        protected void done() {
            flag.set(false);
        }

    }