public static String getExcutionPath(){
        String path = "";
        try {
            path =PathUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Somthing went wrong couldn't detemine our current location !");
        }
        return path.substring(0, path.lastIndexOf("/"));
    }