public abstract class AbstractRook() {
    public abstract void voidCastleRight();
}

public class ShortRook() extends AbstractRook{
    @Override
    public void voidCastleRight() {
        getPlayer().setkSC(false); //void King Side Castling (Short Castle)
    }
}

public class LongRook() extends AbstractRook{
    @Override
    public void voidCastleRight() {
        getPlayer().setqSC(false); //void Queen Side Castling (Long Castle)
    }
}

public class PromotedRook() extends AbstractRook{
    @Override
    public void voidCastleRight() {
        throw new IllegalStateException("Promoted rook cannot castle");
    }
}