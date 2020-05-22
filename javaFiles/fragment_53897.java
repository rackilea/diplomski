public class Demo {

        static Boolean blnMouseDown=false;
        static int xPos=0;
        static int yPos=0;

        public static void main(final String[] args) {
            Display display=new Display();
            final Shell shell = new Shell( Display.getDefault(), SWT.RESIZE); 
            shell.open();

            shell.addMouseListener(new MouseListener() {

                @Override
                public void mouseUp(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    blnMouseDown=false;
                }

                @Override
                public void mouseDown(MouseEvent e) {
                    // TODO Auto-generated method stub
                    blnMouseDown=true;
                    xPos=e.x;
                    yPos=e.y;
                }

                @Override
                public void mouseDoubleClick(MouseEvent arg0) {
                    // TODO Auto-generated method stub

                }
            });
            shell.addMouseMoveListener(new MouseMoveListener() {

                @Override
                public void mouseMove(MouseEvent e) {
                    // TODO Auto-generated method stub
                    if(blnMouseDown){

                        shell.setLocation(shell.getLocation().x+(e.x-xPos),shell.getLocation().y+(e.y-yPos));
                    }
                }
            });

            while (!shell.isDisposed()) {
              if (!display.readAndDispatch()) {
                display.sleep();
              }
            }  
            display.close();
        }

    }