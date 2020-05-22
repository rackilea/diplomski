// 'parent' is assumed to be an SWT composite
 Link link = new Link(parent, SWT.NONE);
    String message = "This is a link to <a href=\"www.google.com\">Google</a>";
    link.setText(message);
    link.setSize(400, 100);
    link.addSelectionListener(new SelectionAdapter(){
        @Override
        public void widgetSelected(SelectionEvent e) {
               System.out.println("You have selected: "+e.text);
               try {
                //  Open default external browser 
                PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new URL(e.text));
              } 
             catch (PartInitException ex) {
                // TODO Auto-generated catch block
                 ex.printStackTrace();
            } 
            catch (MalformedURLException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
        }
    });