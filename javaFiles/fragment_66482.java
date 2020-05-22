/**
 * Adds an entity to the chunk. Args: entity
 */
public void addEntity(Entity entityIn)
{
    this.hasEntities = true;
    int i = MathHelper.floor_double(entityIn.posX / 16.0D);
    int j = MathHelper.floor_double(entityIn.posZ / 16.0D);

    if (i != this.xPosition || j != this.zPosition)
    {
        logger.warn("Wrong location! (" + i + ", " + j + ") should be (" + this.xPosition + ", " + this.zPosition + "), " + entityIn, new Object[] {entityIn});
        entityIn.setDead();
    }

    // ... rest of the method
}