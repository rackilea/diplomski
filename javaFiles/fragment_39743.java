enum An {a1, a2, a3, a0}

class PathKeys {
    String pathKey1;
    String pathKey2;

    PathKeys(String pathKey1, String pathKey2) {
        this.pathKey1 = pathKey1;
        this.pathKey2 = pathKey2;
    }
}

Map<An, PathKeys> channels = new EnumMap<>(An.class);

void put(An an, PathKeys pk) {
    channels.put(an, pk);
}

put(An.valueOf("a1"), new PathKeys("provider_offices", "provider_offices"));

String s = channels.get(An.a1).pathKey1;