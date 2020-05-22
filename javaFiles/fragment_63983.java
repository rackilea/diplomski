frame1.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    this.m.enableMyButton();
                }
            });