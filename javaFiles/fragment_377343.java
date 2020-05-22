public String createPost() {
    Scanner reader = new Scanner(System. in );
    String message;
    System.out.println("What would you like to share? ");
    message = reader.next();

    // Post myPost = new Post(userName + ": " + message);
    myPost = new Post(userName + ": " + message); // note the difference?

    return "";
}