public static void main(String[] args) throws IOException 
    {

        String content=null;
        File folder = new File("/Application/testdata/ntd.txt");

              content = FileUtils.readFileToString(folder)+"\n";
              System.out.println(content);


        int outside=Integer.parseInt(content.substring(0, content.indexOf("[")).trim());
        System.out.println("int val: "outside);
        String remainingString=content.substring(content.indexOf("["), content.lastIndexOf("]")+1);
        System.out.println("String value: "remainingString);
    }