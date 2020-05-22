//Loops around a block to find other blocks that matches with the center (the given block)
private ArrayList<Block> search(Block center) {
    //The maximum amount of blocks to find (the 'cap', our limit)
    final int max = 25;

    ArrayList<Block> blocks = new ArrayList<>();
    Queue<Block> toSearch = new LinkedList<>();

    //Add the center to list, so it has something to start the search
    toSearch.add(center);

    //While we have something to search and have not reached the limit (the 'cap')
    while (toSearch.size() > 0 && blocks.size() < max) {
        Block b = toSearch.remove(); //Get the block on top of the queue, (and remove it)

        blocks.add(b); //Since this block is already of the type we want, we add it the found list (in this case is the 'blocks' var)

        //Find all its neighbours
        for (Block around : findNeighbours(b)) {
            //We do this check here too 'cause findNeighbours() might return up to 26 blocks and it might be too much
            //eg. we have a max of 50 blocks and have already found 45, if findNeighbours find more than five blocks we want to ignore to others
            //that way we stay within our limit, and once this check is made once the whole loop will end
            if (blocks.size() >= max) {
                break;
            }

            //Only add this block if not yet found/processed/searched
            if (toSearch.contains(around) || blocks.contains(around)) {
                continue;
            }

            toSearch.add(around);
        }

        //If in our toSearch list we already enough blocks to fill our limit we stop the search and add as much as we need to fill up out limit.
        //This can save some resources when searching for common blocks like dirt and stone, which we might find a lot and not all of them will be added to our list
        if (toSearch.size() + blocks.size() >= max) {
            int remains = max - blocks.size(); //Gets how many more blocks we need to fulfill our goal (the limit)

            for (int i = 0; i < remains; i++) {
                blocks.add(toSearch.remove());
            }

            break;
        }
    }

    return blocks;
}

//Finds all neighbours around a block
private List<Block> findNeighbours(Block block) {
    //to avoid a bunch of ifs we use these 3 fors to loop over each axis (X, Y, Z)

    ArrayList<Block> blocks = new ArrayList<>();

    //SQUARED 'radius' to search around
    final int searchRadius = 1;

    for (int x = -searchRadius; x <= searchRadius; x++) {
        for (int y = -searchRadius; y <= searchRadius; y++) {
            for (int z = -searchRadius; z <= searchRadius; z++) {
                if (x == 0 && y == 0 && z == 0) {continue;}

                //Get the block at this location (x,y,z)
                Block near = block.getLocation().clone().add(x, y, z).getBlock();

                //Check if the found block is a valid match. eg: is the same type, has the same data/variant
                if (match(near, block)) {
                    blocks.add(near);
                }
            }
        }
    }

    return blocks;
}

//Checks if a matches to b
private boolean match(Block a, Block b) {
    //Checks only the block type, ot its variant/data
    //return a.getType() == b.getType();

    //Checks its type and its data/variant (might not work on all bukkit/spigot versions)
    return a.getType() == b.getType() && a.getState().getData().equals(b.getState().getData());
}