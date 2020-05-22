public static void main(String[] args){
    String fileName = "C:\\Users\\karlk\\workspace\\Work\\src\\test\\tempx.txt";

    try(Scanner scanner = new Scanner(new File(fileName))){
        scanner.useDelimiter(":");

        String name = scanner.next();
        String lang = scanner.next();
        String sex = scanner.next();            
    }catch(FileNotFoundException ex) {
        System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
    }catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + fileName + "'");
    }
}