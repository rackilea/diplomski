final int [] returnCode = new int[1];

Display.getDefault().syncExec(new Runnable()
     {
        @Override
        public void run()
        { 
           MessageDialog dialog = ....

           returnCode[0] = dialog.open();
        }
     });

if (returnCode[0] == 0)
.....