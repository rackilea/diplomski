public class Status {
    Move move;

    public Status(Move move) {
        this.move = move;
    }

    public void getStatus() {
        System.out.println(move.y);
    }
}