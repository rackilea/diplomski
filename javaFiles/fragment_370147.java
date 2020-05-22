public class AlternatingJTable extends JTable {
  private static final Color ALTERNATE_ONE = Color.YELLOW;
  private static final Color ALTERNATE_TWO = Color.GRAY;

  private Color alternateColor = ALTERNATE_ONE;
  private Color whiteColor = Color.WHITE;

  @Override
  public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
    Component returnComp = super.prepareRenderer(renderer, row, column);

    if (!returnComp.getBackground().equals(getSelectionBackground())){
        Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
        returnComp .setBackground(bg);
        bg = null;
    }
    return returnComp;
  };

  public void toggleAlternateColor() {
    if(this.alternateColor == ALTERNATE_ONE) {
      this.alternateColor = ALTERNATE_TWO;
    } else {
      this.alternateColor = ALTERNATE_ONE;
    }
  }
}