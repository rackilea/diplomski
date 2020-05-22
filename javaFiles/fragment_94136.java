public class BlockLoader {
    /**
     * Loads all blocks into memory
     * and populates the BlocksLibary
     * with decent values.
     */
    public static void loadBlocks() {
        GameRegistry.registerBlock(
                BlocksLibrary.blockDarkStone = new BlockDarkStone(Material.rock),
                BlocksLibrary.DARKSTONE
                );
    }
}