public class IncrementButton extends ImageButton {

    public final int rowNumber;
    public final boolean decrement;

    public IncrementButton (Skin skin, String styleName, int rowNumber, boolean decrement){
        super(skin, styleName);
        this.rowNumber = rowNumber;
        this.decrement = decrement;
    }
}