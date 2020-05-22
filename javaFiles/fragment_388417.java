int memsize = 10;
    int[] mem = new int [memsize];
    int memory = -memsize;

    mem [0] = memory;
    mem [mem.length-1] = memory;

    for (int x= 0; x <= mem.length - 1 ; x++){
        if (x != 0) {
            System.out.print(" , ");
        }
        System.out.print(mem[x]);
    }