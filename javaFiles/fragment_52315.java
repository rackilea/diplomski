public class Robot {
    public int x;
    public int y;
    public Robot(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public void move(int direction, int steps) {
        switch(direction) {
            case 1: //north
                int temp1 = (x-steps)%8;
                x = temp1<0?(temp1+8):temp1;
                break;
            case 2: //south
                x = (x+steps)%8;
                break;
            case 3: //west
                int temp3 = (y-steps)%8;
                y = temp3<0?(temp3+8):temp3;
                break;
            case 4: //east
                y = (y+steps)%8;
                break;
            default:
                System.out.println("I'm not smart enough to handle the direciton provided!");
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[8][8];
        Robot robot = new Robot(0,0);
        System.out.println("I'm starting at (0,0).");
        robot.move(3, 9);
        System.out.println("I'm moving west by 9 steps.");
        System.out.println("I've arrived at ("+robot.x+","+robot.y+").");
    }
}