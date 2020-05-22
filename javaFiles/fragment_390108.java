int numOfMines =  10;

    int rows=5,columns=5;


    ArrayList listWithMines = new ArrayList();

    while(listWithMines.size()<numOfMines) {

        int randRow = random.nextInt(rows);
        int randCol = random.nextInt(columns);

        Point point = new Point(randRow, randCol);

        if(listWithMines.contains(point))
            continue;
        else
            listWithMines.add(point);
    }