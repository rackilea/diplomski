private void createScheduledTask(String taskName) {
    List<String> commandList = new ArrayList<String>();
    commandList.add("schtasks.exe");
    commandList.add("/Create");
    commandList.add("/tn");
    commandList.add(taskName);
    commandList.add("/sc");
    commandList.add("Minute");
    commandList.add("/tr");
    commandList.add("java -jar C:\\Users\\MyUser\\Desktop\\Program.jar REPLACE_WITH_ARGUMENT");
    try {
        int returnValue = executeCMDStatement(commandList);
        if(returnValue == 0){
            //everything should have worked out
        } else {
            //there was an error 
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public static int executeCMDStatement(List<String> commandList) throws InterruptedException, IOException {
    ProcessBuilder builder = new ProcessBuilder(commandList);
    Process process = builder.start();
    process.waitFor(3, TimeUnit.SECONDS);
    return process.exitValue();
}