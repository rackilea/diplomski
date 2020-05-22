public static void main(String[] argv) throws InterruptedException, InvocationTargetException
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        UIManager.setLookAndFeel(new SubstanceSaharaLookAndFeel());
                        //Some people say the below should also be called but even without it always worked for me so what is this for then?
                        //SwingUtilities.updateComponentTreeUI(frame);
                    }catch(Exception e)
                    {
                        Logger.getLogger(MyApplicationFrame.class.getName()).log(Level.SEVERE, null, e);
                        System.out.println("Substance look and feel failed to initialize");
                    }
                    new MyApplicationFrame();
                }
            });
        }