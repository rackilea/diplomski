public void writeToFile(){
    String file_text= pedStatusText + "     " + gatesStatus + "     " + DrawBridgeStatusText;
    try {
        writer.write(file_text);
        writer.flush();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}