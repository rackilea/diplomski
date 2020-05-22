class Thing implements Comparable<Thing> {

    final String a;
    final int x;
    final int y;
    final int z;

    public Thing(String a, int x, int y, int z) {
        this.a = a;
        this.x = x;
        this.y = y;
        this.z = z;

    }

    @Override
    public int compareTo(Thing o) {
        int diff = o.x - x;
        if (diff == 0) {
            diff = o.y - y;
        }
        if (diff == 0) {
            diff = o.z - z;
        }
        return diff;
    }

    @Override
    public String toString() {
        return "{" + a + "," + x + "," + y + "," + z + "}";
    }
}

public static int max(Thing[] things) {
    // NB - This should really call compareTo.
    int max = 0;
    for (int i = 1; i < things.length; i++) {
        int diff = things[i].x - things[max].x;
        if (diff == 0) {
            diff = things[i].y - things[max].y;
        }
        if (diff == 0) {
            diff = things[i].z - things[max].z;
        }
        if (diff > 0) {
            // Higher
            max = i;
        }
    }
    return max;
}

public void test() {
    Thing[] things = new Thing[6];
    things[0] = new Thing("Hello", 1, 2, 3);
    things[1] = new Thing("There", 1, 2, 4);
    things[2] = new Thing("Everyone", 0, 2, 3);
    things[3] = new Thing("How", 9, 0, 3);
    things[4] = new Thing("Are", 8, 9, 3);
    things[5] = new Thing("You", 7, 2, 3);
    System.out.println("Before: " + Arrays.toString(things));
    System.out.println("Max: " + things[max(things)]);
    Arrays.sort(things);
    System.out.println("Sorted: " + Arrays.toString(things));
}