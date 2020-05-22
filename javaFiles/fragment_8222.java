while ((line = br.readLine() ) != null ){

    char[] row = line.toCharArray();
        int x = 0;
        for (int i = 0; i < row.length; i++) {
        maze[x][i] = row[i];

        System.out.print(maze[i]);
        x++;
        }
        System.out.printf("%n");  //mention this
    }