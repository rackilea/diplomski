public class ExeConsole extends JFrame{
    [...]
    // The line buffers must be declared outside the method
    InputStreamLineBuffer outBuff, errBuff; 
    public ExeConsole{
        [...]
        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 if(pro != null){
                      pro.destroy();
                      outBuff.destroy();
                      errBuff.destroy();
                 }
        }});
    }
    [...]
    private void exec(String command) throws IOException{
        [...]
        //InputStreamLineBuffer outBuff = new InputStreamLineBuffer(inStream);
        //InputStreamLineBuffer errBuff = new InputStreamLineBuffer(inErrStream);        
        outBuff = new InputStreamLineBuffer(inStream);
        errBuff = new InputStreamLineBuffer(inErrStream);    
        [...]
    }
}