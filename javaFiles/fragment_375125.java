class Room {
int x;
int y;
int height;
int width;

public Room(int rx, int ry, int rwidth, int rheight) {
    x = rx;
    y = ry;
    height = rheight;
    width = rwidth;
}

boolean overlaps(Room[] roomlist) {
    Rectangle r1 = new Rectangle(x, y, width, height);
    if (roomlist != null) {
        for (int i = 0; i < roomlist.length; i++) {
            if (roomlist[i] != null) {
                Rectangle r2 = new Rectangle(roomlist[i].x, roomlist[i].y, roomlist[i].width, roomlist[i].height);
                if (r2.intersects(r1)) {
                    return true;
                } 
            }
        }
    }
    return false;
}
}

public class RoomGenerator {
private static final int ROOMS = 10;
private static final int WIDTH = 1200;
private static final int HEIGHT = 1000;
private static final int MINROOMSIZE = 10;
private static final int MAXROOMSIZE = 120;

public static void main(String[] args) {
    generateMap();
}

public static void generateMap() {
    Room rooms[] = new Room[10];
    for (int i = 0; i < ROOMS; i++) {
        int x = randomWithRange(0, WIDTH);
        int y = randomWithRange(0, HEIGHT);
        int height = randomWithRange(MINROOMSIZE, MAXROOMSIZE);
        int width = randomWithRange(MINROOMSIZE, MAXROOMSIZE);
        while (x + width > WIDTH) {
            x--;
        }
        while (y + height > HEIGHT) {
            y--;
        }
        Room room = new Room(x, y, width, height);
        if( i ==0)
        {
            rooms[0] = room;
        }else if (room.overlaps(rooms) == false) {
            rooms[i] = room;
        }
    }
}

private static int randomWithRange(int min, int max) {
    // TODO Auto-generated method stub
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
}
}