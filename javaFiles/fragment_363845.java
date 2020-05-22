void checkBlocks(Block b, int amm) {
  Stack<Block> blocks = new Stack<Block>();
  blocks.push(b);
  while (!blocks.isEmpty()) {
    b = blocks.pop();
    Block blockDown = (Block) b.getRelative(BlockFace.DOWN);
    if (condition)
      blocks.push(block);
    Block blockUp = (Block) b.getRelative(BlockFace.UP);
    if (condition) 
      blocks.push(block);
  }
}