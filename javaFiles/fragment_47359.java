import java.util.Scanner;
public class Play {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        TicTacToeBoard t = new TicTacToeBoard(3, 3);
        t.startBoard();
        XO xo1 = new XO();
        xo1.setName("O");
        XO xo2 = new XO();
        xo2.setName("X");
        System.out.println("Player 1, what is your name?");
        String n1 = kbd.nextLine();
        System.out.println("Player 2, what is your name?");
        String n2 = kbd.nextLine();
        System.out.println(t);
        while (!t.winner() && !t.full()) {
            if (t.getTurnCnt() % 2 == 0) {
                System.out.println(n1 + "(X): ");
                int x1 = kbd.nextInt();
                int y1 = kbd.nextInt();
                t.add(x1, y1, xo1);
                System.out.println(t);
            }
            //this is where the board resets
            else {
                System.out.println(n2 + "(O): ");
                int x2 = kbd.nextInt();
                int y2 = kbd.nextInt();
                t.add(x2, y2, xo2);
                System.out.println(t);
            }
        }
    }
}
     class TicTacToeBoard {
        private XO[][] board;
        private int turnCnt;
        public TicTacToeBoard(int r, int c){

            board=new XO[r][c];
            turnCnt=0;
        }
        public void startBoard(){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    board[i][j]=new XO();
                    board[i][j].setName("-");
                }
            }
        }
        public void setTurnCnt(int t){
            turnCnt=t;
        }
        public XO[][] setBoard(XO[][] b){
            return b;
        }
        public XO[][] getBoard(){
            return board;
        }
        public int getTurnCnt(){
            return turnCnt;
        }
        public boolean add(int x, int y, XO x1){
            if(x<=this.getRows()&&y<=this.getCols()&&(board[x-1][y-1].getName().equals("-"))){
                board[x-1][y-1].setName(x1.getName());
                turnCnt++;
                return true;
            }
            else
                System.out.println("error");
            return false;
        }
        public boolean winner(){
            boolean t=false;
            for(int i=0;i<3;i++){
                if(board[i][0].equals(board[i][1], board[i][2])||board[0][i].equals(board[1][i], board[2][i])||board[0][0].equals(board[1][1], board[2][2])||board[2][0].equals(board[1][1], board[0][2]))
                    t=true;
            }
            return t;
        }
        public boolean XWinner(){
            boolean t=false;
            for(int i=0;i<3;i++){
                if((board[i][0].equals(board[i][1], board[i][2])&&board[i][1].getName().equals("X"))||(board[0][i].equals(board[1][i], board[2][i])&&board[0][i].getName().equals("X"))||(board[0][0].equals(board[1][1], board[2][2])&&board[0][0].getName().equals("X"))||(board[2][0].equals(board[1][1], board[0][2])&&board[2][0].getName().equals("X")))
                    t=true;
            }
            return t;
        }
        public boolean full(){
            boolean t=true;
            for(int r=0;r<3;r++){
                for(int c=0;c<3;c++){
                    if(board[r][c].getName()=="-")
                        t=false;
                }
            }
            return t;
        }
        public String toString(){
            return "\t\t\tCol\n\t\t1\t2\t3\nRow\t1\t"+board[0][0]+"\t"+board[0][1]+"\t"+board[0][2]+"\n\t2\t"+board[1][0]+"\t"+board[1][1]+"\t"+board[1][2]+"\n\t3\t"+board[2][0]+"\t"+board[2][1]+"\t"+board[2][2];
        }

         public int getRows() {
             return 3;
         }

         public int getCols() {
             return 3;
         }
     }
     class XO {

       String name="-";

        public void setName(String name){
            this.name=name;
        }

        public String getName(){
            return name;

        }
        public boolean equals(XO x1, XO x2){
            return(x1.getName().equals(this.getName())&&x2.getName().equals(this.getName())&&this.getName()!="-");
        }

         @Override
         public String toString() {
             return getName();
         }
     }