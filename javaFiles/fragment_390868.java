// Getting a list of all types
Collection<BlockType> types = Sponge.getRegistry().getAllOf(BlockType.class)
for (BlockType type : types) {
    System.out.println(type.getName());
}

// Getting a single type by name
Optional<BlockType> type = Sponge.getRegistry().getType(BlockType.class, "minecraft:chest");
if (!type.isPresent()) {
    // show some error, as the given type doesn't exist
} else {
    return type.get();
}