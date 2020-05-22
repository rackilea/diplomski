public class Board {
    List<Square> squares;

    public render() {
        // Render your board first
        ...

        // Render child squares
        for (Square square : squares) {
            square.render();
        }
    }
}