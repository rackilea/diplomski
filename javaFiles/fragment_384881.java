public static void main(String[] args){
       loadSetupMessage("myJsonfile.json");
    }

    protected void loadSetupMessage(String fileName) throws IOException {
        String rawMessage = this.loadResource(fileName);
        System.out.println(String.format("loaded class %s", rawMessage);
    }