while(tCount < tRan)   {
    System.out.println(tRan);
    tCount ++;
    int treeX = treeSpawn.nextInt(width * 5);

    if(treeX < 256)    {
        treeX = 256;
    }

    tiles[treeX] = Tile.LOG.getId();
    tiles[treeX + width] = Tile.LOG.getId();
    tiles[treeX + width + width] = Tile.LOG.getId();
    tiles[treeX - width] = Tile.LEAVES.getId();
    ... // Rest of the tree drawing code
}