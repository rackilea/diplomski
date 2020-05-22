public class DynamicSelectionCell extends AbstractCell<MyDTO> {


    @Override
    public void render(Context context, MyDTO value, SafeHtmlBuilder sb) {

      if (value == null) {
        return;
      }
       // render a selectionbox and dynamically add options by accessing the value.getAvailablOptions() 
    }
  }