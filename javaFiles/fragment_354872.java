while (in.hasNextLine()){
        s = in.nextLine();
        c = s.charAt(i);
        while (c != ' '){
            System.out.print(c);
            i++;
            c = s.charAt(i);
        }
        System.out.println();
        i = 0; // Finished with this line
    }