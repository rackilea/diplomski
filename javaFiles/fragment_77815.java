if (maze[l][f].equals("/")) {
        if ((l+1) >= rows) {
            System.out.println("You died on column " + (f + 1));
            System.exit(0);
            y+=1;
        } else {
            //maze[l][f] = "x"; // only if you want to replace the '/' char
            l+=1; // to go down, add one (first line has index 0)
            f+=1;
            y+=1;
        }
    } else if (maze[l][f].equals("\\")) {
        if ((l-1) < 0){
            System.out.println("You died on column " + (f + 1));
            System.exit(0);
            y+=1;
        } else {
            maze[l][f] = "x"; // only if you want to replace the '\' char
            l-=1; // to go up, substractone (first line has index 0)
            f+=1;
            y+=1;
        }
    } else if (maze[l][f].equals("|")) {
        System.out.println("You died on column" + (f+1));
        System.exit(0);
        y+=1;
    } else {
        maze[l][f] = "x"; // mark the current position before moving to the next one
        f+=1;
        y+=1;
    }