public final class BlockRenderRegister {
    public static void registerBlockRenderer() {
        register(BlocksLibrary.blockDarkStone);
    }
    public static void register(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(block), 
                          0, 
                          new ModelResourceLocation(
                                ModHooks.MODID.toLowerCase() + ":" + BlocksLibrary.DARKSTONE, 
                                "inventory"
                                 )
                          );
    }
}