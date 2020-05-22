public interface MomentOfInertia extends Quantity {

    public final static Unit<MomentOfInertia> UNIT = 
        new ProductUnit<MomentOfInertia>(SI.KILOGRAM.times(SI.SQUARE_METRE));

}