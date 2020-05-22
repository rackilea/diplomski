@SuppressWarnings("deprecation")
public static void changeChestState(Location loc, boolean open) {
    byte dataByte = (open) ? (byte) 1 : 0; // The byte of data used for the note and animation packet (1 if true, 0 if false)
    for (Player player : Bukkit.getOnlinePlayers()) {
        player.playNote(loc, (byte) 1, dataByte); // Play the sound
        BlockPosition position = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()); // Create the block position using loc
        // Instantiate animation packet, get NMS Block using getById() and loc.getBlock() (deprecated), the server version may vary
        PacketPlayOutBlockAction blockActionPacket = new PacketPlayOutBlockAction(position, net.minecraft.server.v1_8_R3.Block.getById(loc.getBlock().getTypeId()), (byte) 1, dataByte);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(blockActionPacket); // Send animation packet to CraftPlayer
    }
}