public abstract class Piece {

    public abstract List<Field> getFieldsAllowed(Field field);
}
public class Rook extends Piece {

    @Override
    public List<Field> getFieldsAllowed(Field field) {
        // TODO Auto-generated method stub
        return null;
    }    
}
public class Field {

    public Piece getPiece() {
        // get current piece
    }
}