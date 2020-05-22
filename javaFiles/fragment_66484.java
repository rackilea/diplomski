@SubscribeEvent
public void onEntityJoinWorld(EntityJoinWorldEvent event) {
    if (event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote) {
        queueTeleportNextTick(event.entity, Math.random() * 200 - 100, 73,
                Math.random() * 200 - 100, 0, 0);
    }
}

/**
 * List of teleports to perform next tick.
 */
private List<TeleportInfo> queuedTeleports = new ArrayList<TeleportInfo>();

/**
 * Stores information about a future teleport.
 */
private static class TeleportInfo {
    public TeleportInfo(Entity entity, double x, double y, double z,
            float yaw, float pitch) {
        this.entity = entity;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public final Entity entity;
    public final double x;
    public final double y;
    public final double z;
    public final float yaw;
    public final float pitch;
}

/**
 * Teleport the given entity to the given coordinates on the next game tick.
 */
public void queueTeleportNextTick(Entity entity, double x, double y,
        double z, float yaw, float pitch) {
    System.out.printf("Preparing to teleport %s to %f, %f, %f%n", entity, x, y, z);
    queuedTeleports.add(new TeleportInfo(entity, x, y, z, yaw, pitch));
}

@SubscribeEvent
public void teleportEntiesOnWorldTick(TickEvent.WorldTickEvent event) {
    // Make sure that this is the type of tick we want.
    if (event.phase == TickEvent.Phase.START && event.type == TickEvent.Type.WORLD) {
        // Perform each teleport
        Iterator<TeleportInfo> itr = queuedTeleports.iterator();
        while (itr.hasNext()) {
            TeleportInfo info = itr.next();
            if (info.entity.worldObj == event.world) {
                System.out.printf("Teleporting %s to %f, %f, %f%n", info.entity, info.x, info.y, info.z);
                if (info.entity instanceof EntityPlayerMP) {
                    // EntityPlayerMPs are handled somewhat differently.
                    ((EntityPlayerMP) info.entity).playerNetServerHandler
                            .setPlayerLocation(info.x, info.y, info.z,
                                    info.pitch, info.yaw);
                } else {
                    info.entity.setLocationAndAngles(info.x, info.y, info.z,
                            info.pitch, info.yaw);
                }
                itr.remove();
            }
        }
    }
}