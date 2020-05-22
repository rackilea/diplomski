for(; blockSelector.getBlockX() != getPoint2X; blockSelector.setX(replaceVarX))
{
    for(; blockSelector.getBlockZ() != getPoint2Z; blockSelector.setZ(replaceVarZ) )
    {
        for(; blockSelector.getBlockY() != getPoint2Y; blockSelector.setY(replaceVarY))
        {
            lobbies.put(blockSelector.getBlockY(), blockSelector);
        }
        lobbies.put(blockSelector.getBlockZ(), blockSelector);
    }
    lobbies.put(blockSelector.getBlockZ(), blockSelector);
}