try
            {
                timer = new Timer(1000, new ActionListener()
                {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        checkMark.setVisible(false);
                        panel.repaint();
                        timer.stop();

                    }
                });
                timer.start();

            }
            catch(Exception e5)
            {
                e5.printStackTrace();
                timer.stop();
            }