public JSWrapper selectFolder(){
    final Applet applet = this;
    return AccessController.doPrivileged(new PrivilegedAction<JSWrapper>() {
        public JSWrapper run() {
            JSWrapper wrap = new JSWrapper();
            try{        
                JFileChooser folderchooser = new JFileChooser();
                int returnValue = folderchooser.showSaveDialog(applet);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    wrap.setRV(folderchooser.getSelectedFile().getAbsolutePath());
                } else {
                    wrap.setRV(null);
                }
            } catch (ApplicationBaseException e) {
                wrap.setRV(null);
                wrap.setException(e);                   
            } catch (Exception e2) {
                wrap.setRV(null);
                wrap.setException(e2);  
            }               
            return wrap;
        }
    });                     
}