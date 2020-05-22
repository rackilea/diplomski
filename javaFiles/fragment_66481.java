/**
 * Called when an entity is spawned in the world. This includes players.
 */
public boolean spawnEntityInWorld(Entity p_72838_1_)
{
    // do not drop any items while restoring blocksnapshots. Prevents dupes
    if (!this.isRemote && (p_72838_1_ == null || (p_72838_1_ instanceof net.minecraft.entity.item.EntityItem && this.restoringBlockSnapshots))) return false;

    int i = MathHelper.floor_double(p_72838_1_.posX / 16.0D);
    int j = MathHelper.floor_double(p_72838_1_.posZ / 16.0D);
    boolean flag = p_72838_1_.forceSpawn;

    if (p_72838_1_ instanceof EntityPlayer)
    {
        flag = true;
    }

    if (!flag && !this.isChunkLoaded(i, j, true))
    {
        return false;
    }
    else
    {
        if (p_72838_1_ instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)p_72838_1_;
            this.playerEntities.add(entityplayer);
            this.updateAllPlayersSleepingFlag();
        }

        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.EntityJoinWorldEvent(p_72838_1_, this)) && !flag) return false;

        this.getChunkFromChunkCoords(i, j).addEntity(p_72838_1_);
        this.loadedEntityList.add(p_72838_1_);
        this.onEntityAdded(p_72838_1_);
        return true;
    }
}