public  static void setTechnicalName(File javaFile) throws IOException {
    if(javaFile.exists()) {
        BufferedReader reader = new BufferedReader(new FileReader(javaFile));
        String line = null;
        int statusOffet = "status.".length();
        while((line = reader.readLine()) != null){
            int indexOfStatus = line.indexOf("status");
            int indexOfName = line.lastIndexOf(".name");                
            boolean isReqLine = line.contains("In approval")
                                        || line.contains("In Approval")
                                        || line.contains("In review")
                                        || line.contains("In Review") 
                                        || line.contains("Closed");

            if(isReqLine && indexOfStatus != -1 && indexOfName != -1){
                System.out.println(line);
                String stage = line.substring(indexOfStatus + statusOffet, indexOfName); 
                System.out.println(stage);
            }

        }
        reader.close();
    }
}