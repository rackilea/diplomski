// it's not necessary to specify the initial capacity,
// but this is the correct way to do it for this problem
tiles = new ArrayList<Tile>(2*size + 1);

// first add all the 'O'
for (int index = 0; index < size; index++)
    tiles.add(new Tile('O'));
// add the ' '
tiles.add(new Tile(' '));
// finally add all the 'X'
for (int index = 0; index < size; index++)
    tiles.add(new Tile('X'));

// verify the result, for size=2
System.out.println(tiles);
=> [O, O,  , X, X]