Map<Integer, List<Planet>> map = new HashMap<>();
map.put(1, new ArrayList<>());
map.put(2, new ArrayList<>());
map.put(3, new ArrayList<>());

for (int x=0; x<width; x++)
{
    for (int y=0; y<height; y++)
    {
        if (world[x][y] == 1) //Find all Stars in world
        {
            // Taking in consideration the fact that Stars are Planets
            map.get(1).add(new Star(/*args*/));
        }
        else if (world[x][y] == 2) //Find all Planets ('2') in world
        {
            map.get(2).add(new Planet(
                    randInt(1024, 512),
                    randFloat(4, 0),
                    randInt(360, 0)
            ));
        }
    }
}