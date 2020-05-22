public class Queens {
    static int counter = 0;
    static int[] pos = new int[8];

    static void printBoard(){
        for(int p: pos) {
            for(int i = 0; i < p; i++) System.out.print(".");
            System.out.print("Q");
            for(int i = p+1; i < 8; i++) System.out.print(".");
            System.out.println();
        }
        System.out.println();
    }

    static boolean threatened(int x, int y){
        for (int i = 0; i < y; i++){
            int d = y - i;
            if(pos[i] == x || pos[i] == x - d || pos[i] == x + d) {
                return true;
            }
        }
        return false;
    }

    static void place(int y) {
        for(int x = 0; x < pos.length ; x++){
            if(!threatened(x, y)){
                pos[y] = x;
                if(y == 7){
                    printBoard();
                    counter++;
                } else{
                    place(y + 1);
                }
            }
        }
    }

    public static void main(String[] args){
        place(0);
        System.out.print("found " + counter + " solutions");
    }
}