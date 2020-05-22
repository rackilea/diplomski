private Map<Integer, Map<Integer, Map<Integer, Chunk>>> chunks = new HashMap<Integer, Map<Integer, Map<Integer, Chunk>>>();

Map<Integer, Map<Integer, Chunk>> inner1 = new HashMap<Integer, Map<Integer, Chunk>>();
chunks.put(x, inner1);

Map<Integer, Chunk> inner2 = new HashMap<Integer, Chunk>();
inner1.put(y, inner2);

inner2.put(z, new Chunk(x, y, z, param1, param2));