public static void main(String[] args) {
    WordHistogram hist = new  WordHistogram();
    FileInputController input = new FileInputController(hist);
    FileOutputController output = new FileOutputController(hist);

    try {
        input.readWords(args[0]);  //args[0] is the first argument passed while launching Java
        output.writeWords(args[1]);  //args[1] is the second argument passed while launching Java
    } catch (FileNotFoundException exception) {
        System.out.println("exception caught! somthing went wrong: " + exception.getMessage());
    } catch (IOException exception) {
        System.out.println("exception caught! somthing went wrong: " + exception.getMessage());
    } finally {
        System.exit(1);
    }
}