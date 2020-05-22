private static List<Tile> getTilesWithColor1(List<Tile> tilesList, String searchColor) {
    return tilesList.stream()
                     .filter(tile -> tile.getColour().equals(searchColor))
                     .collect(Collectors.toList());
}

private static List<Tile> getTilesWithColor2(List<Tile> tilesList, String searchColor) {
    List<Tile> result = new ArrayList<>();
    for (Tile t : tilesList) {
        if (t.getColour().equals(searchColor)) {
            result.add(t);
        }
    }
    return result;
}