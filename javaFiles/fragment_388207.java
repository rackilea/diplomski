Board()
{
    cells = new Cell[3][3];
    for(int i=0; i<3; i++)
        for(int j=0; j<3; j++)
            cells[i][j] = new Cell()
            cells[i][j].content = Seed.EMPTY;
}