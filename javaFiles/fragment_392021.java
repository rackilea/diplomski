Iterator<Map.Entry<Player, Double>> itr = map.entrySet().iterator();
while (itr.hasNext()) {
    if (itr.next().getValue() <= radiusSquared) {
        itr.remove();
    }
}