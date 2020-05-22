Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();
        for (int c = 0; c < t; c++)
        {
            String word = in.nextLine();
            Note note = new Note(word);
            System.out.println("Note " + c + " says: " + note.getContent());
        }