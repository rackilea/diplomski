Board board = null;
Pawn p1 = null;

@Before
public void setup() {
    board = new Board();
    p1 = new Pawn(Player.UP);
}