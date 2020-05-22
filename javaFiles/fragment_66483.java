List<Entity> playersToTeleport = new ArrayList<Entity>();

@SubscribeEvent
public void onEntityJoinWorld(EntityJoinWorldEvent event) {
    if (event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote) {
        playersToTeleport.add(event.entity);
    }
}

@SubscribeEvent
public void teleportEntiesOnWorldTick(TickEvent.WorldTickEvent event) {
// Make sure that this is the type of tick we want.
if (event.phase == TickEvent.Phase.START && event.type == TickEvent.Type.WORLD) {
        for (Entity entity : playersToTeleport) {
            if (entity.worldObj == event.world) {
                if (entity instanceof EntityPlayerMP) {
                    ((EntityPlayerMP) entity).playerNetServerHandler.setPlayerLocation(145, 73, 145, 0, 0);
                } else {
                    entity.setLocationAndAngles(145, 73, 145, 0, 0);
                }
            }
        }
        playersToTeleport.clear();
    }
}