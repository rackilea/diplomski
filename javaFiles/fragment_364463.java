ObjectNodeManager.OBJECTS.findAll {
    it.getPosition().withinDistance(player.getPosition(), 30))
}.each{
    ObjectNode newRock = new ObjectNode(439, it.position, ObjectDirection.NORTH, ObjectType.DEFAULT)
    ObjectNodeManager.unregister(it)
    ObjectNodeManager.register(newRock)
    it.remove()
}