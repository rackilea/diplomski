Block removeMe;
for (Iterator<Block> iterator = Blocks.iterator();  iterator.hasNext();) {
        Block block = (Block) iterator.next();
        if (block.getX() == x && block.getY() == y) {
            removeMe = block; 
            iterator.remove();
            break;
        }
}
removeMe.remove();