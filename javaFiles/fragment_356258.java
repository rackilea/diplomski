package stackoverflow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Chess {

    enum Rank {
        // this time lower case even if these are constants
        a, b, c, d, e, f, g, h
    }

    enum File {
        one, two, three, four, five, six, seven, eight
    }

    enum FigureColor {
        BLACK, WHITE
    }

    interface Figure {

        FigureColor getFigureColor();

        Collection<FigurePosition> getMovements();

        Figure move(FigurePosition figurePosition);

        FigurePosition getCurrentPosition();

    }

    class FigurePosition {

        Rank rank;
        File file;

        public FigurePosition(Rank rank, File file) {
            this.rank = rank;
            this.file = file;
        }

        @Override
        public String toString() {
            return "FigurePosition{" +
                    "rank=" + rank +
                    ", file=" + file +
                    '}';
        }
    }

    abstract class BasicFigure implements Figure {

        private FigureColor figureColor;
        private List<FigurePosition> movements = new ArrayList<FigurePosition>();

        public BasicFigure(FigureColor figureColor, FigurePosition initialFigurePosition) {
            this.figureColor = figureColor;
            move(initialFigurePosition);
        }

        public FigureColor getFigureColor() {
            return figureColor;
        }

        public Collection<FigurePosition> getMovements() {
            return movements;
        }

        public Figure move(FigurePosition figurePosition) {
            movements.add(figurePosition);
            return this;
        }

        public FigurePosition getCurrentPosition() {
            return movements.get(movements.size()-1);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "{" +
                    "figureColor=" + figureColor +
                    ", currentPosition=" + getCurrentPosition() +
                    ", movements=[" + getMovements().stream().map(FigurePosition::toString).collect(Collectors.joining(",")) + "]'}'";
        }
    }

    class Queen extends BasicFigure {

        public Queen(FigureColor figureColor, FigurePosition initialFigurePosition) {
            super(figureColor, initialFigurePosition);
        }

        @Override
        public Figure move(FigurePosition figurePosition) {
            // you can for example validate movements here
            return super.move(figurePosition);
        }
    }

    class King extends BasicFigure {

        public King(FigureColor figureColor, FigurePosition initialFigurePosition) {
            super(figureColor, initialFigurePosition);
        }
    }

    class Pawn extends BasicFigure {

        public Pawn(FigureColor figureColor, FigurePosition initialFigurePosition) {
            super(figureColor, initialFigurePosition);
        }
    }

    /** add other figure classes here */

    @Test
    public void test() {
        Figure whiteQueen = new Queen(FigureColor.WHITE, new FigurePosition(Rank.d, File.one));
        System.out.println(whiteQueen);
        Figure blackPawn1 = new Pawn(FigureColor.BLACK, new FigurePosition(Rank.a, File.seven));
        blackPawn1.move(new FigurePosition(Rank.a, File.six));
        System.out.println(blackPawn1);
    }

}