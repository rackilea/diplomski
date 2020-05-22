class ChessPieceFactory {
    public ChessPiece create(String pieceName, String pieceRepresentation) {
      ChessPiece piece;
      try {
        Class pieceKlass = Class.forName(pieceName)
        Constructor ctor = pieceKlass.getDeclaredConstructor(String.class);
        ctor.setAccessible(true);
        piece = (ChessPiece)ctor.newInstance(pieceRepresentation);
       // production code should handle these exceptions more gracefully
     } catch (ClassNotFoundException x) {
        x.printStackTrace();
     } catch (InstantiationException x) {
        x.printStackTrace();
     } catch (IllegalAccessException x) {
        x.printStackTrace();
     } catch (InvocationTargetException x) {
        x.printStackTrace();
     } catch (NoSuchMethodException x) {
        x.printStackTrace();
     }

     return piece;
  }