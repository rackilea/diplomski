// As you can see I use a 1 dimensional array of 100 elements
cubes = new Mesh_Cube[100];

for(int x = 0; x < 10; x++)
    for(int z = 0; z < 10; z++)
    {
        // Now I'm properly calculating the index of the new object,
        // Taking into account both x and z
        cubes[x * 10 + z] = new Mesh_Cube(new Vector3(x,0,z), new Vector3(1,0,1));
    }