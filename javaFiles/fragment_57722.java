public void addMovie() {
    for (int x = 0; x < mlist.length; x++) {
        // Deleted the call to default constructor.
        System.out.println("What is the title of the movie? ");
        title = scan.nextLine();
        System.out.println("What is the genre of the movie? ");
        genre = scan.nextLine();
        System.out.println("Who is the director of the movie? ");
        director = scan.nextLine();
        System.out.println("What is the cost of the movie? ");
        cost = scan.nextInt();
        // Added this code
        mlist[x] = new Movies(title,genre,director,cost);
    }
}