@EventHandler
public void onInteractEvent(PlayerInteractEvent e) {
Block interacted = e.getClickedBlock();
//Check if this is the block you want

Block block= interacted.getRelative(BlockFace.UP, 1);    //Can be changed to any block face, and any distance


switch(block.getType()) {
case LEVER:
case REDSTONE:
case DISPENSER:
case POWERED_RAILS:
case whatever other blocks can be powered:
{
      block.setData(block.getData() | 0x8); // sets the 0x8 bit to the data, making it powered
} }