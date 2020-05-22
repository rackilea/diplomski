try{
    Process process = runtime.exec("taskkill /IM notepad.exe");
} catch (IOException ioe){
    JFrame alertFrame = new JFrame();
    JOptionPane.showMessageDialog(alertFrame, "Error closing notepad.");
}