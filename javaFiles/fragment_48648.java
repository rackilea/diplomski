class Piece {
    public static Piece getInstance(Class<? extends Piece> clazz) throws InstantiationException, IllegalAccessException{
        return clazz.newInstance();
    }
}

class Pawn extends Piece {

}