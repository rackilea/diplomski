//maximum width of a line
int maxWidth = 300;

//Space in pixels between the border as well as the blocks
int paddingX = 5;
int paddingY = 5;

//the offset for the next block
int offsetX = paddingX;
int offsetY = paddingY;

int currentLargestHeight = 0;

for( Block block : blocks ) {
  //if the block doesn't fit into the "line" start a new one
  //we assume an empty line always can take at least one block
  if( block.getWidth() > (maxWidth - offsetX - paddingX) ) {
    //advance down
    offsetY += currentLargestHeight + paddingY;

    //we have a new line so the current largest height is 0 again
    currentLargestHeight = 0;

    //start left again
    offsetX = paddingX;
  }

  //render the block
  g2.fillRect(offsetX, offsetY, block.getWidth(), block.getHeight());

  offsetX += block.getWidth() + paddingX;
  if( block.getHeight() > currentLargestHeight ) {
    currentLargestHeight = block.getHeight();
  }
}