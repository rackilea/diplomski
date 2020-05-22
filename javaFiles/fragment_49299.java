import java.util.Vector;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Characters;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.MainScreen;

public final class ListDemoScreen extends MainScreen {

    private Vector _listElements;

    ListField list;
    private ListField _checkList;
    private MenuItem _toggleItem;

    public ListDemoScreen() {
        super(Manager.NO_VERTICAL_SCROLL);
        // Set the displayed title of the screen
        setTitle("List Demo 1");
        add(new LabelField("Fruits List", LabelField.FIELD_HCENTER));
        add(new SeparatorField());

        _listElements = new Vector();
        add(new SeparatorField());
        list = new ListField();
        ListCallback _callback = new ListCallback(this);

        list.setCallback(_callback);
        list.setSize(4);
        int index = list.getSelectedIndex();

        add(list);

        createField();

    }

    protected void createField() {
//      String itemOne = "Apple";
//      String itemTwo = "Blackberry";
//      String itemthree = "Grapes";
//      String itemfour = "Banana";
        ChecklistData itemOneCheckList = new ChecklistData("Apple", false);
        ChecklistData itemTwoCheckList = new ChecklistData("Blackberry", false);
        ChecklistData itemThreeCheckList = new ChecklistData("Grapes", false);
        ChecklistData itemFourCheckList = new ChecklistData("Banana", false);

        _listElements.addElement(itemOneCheckList);
        _listElements.addElement(itemTwoCheckList);
        _listElements.addElement(itemThreeCheckList);
        _listElements.addElement(itemFourCheckList);
        reloadList();

    }

    private void reloadList() {
        list.setSize(_listElements.size());
    }

    public boolean invokeAction(int action) {
        switch (action) {
        case ACTION_INVOKE: // Trackball click.
            int index = list.getSelectedIndex();
            ChecklistData data = (ChecklistData) _listElements.elementAt(index);
            data.toggleChecked();
            _listElements.setElementAt(data, index);
            list.invalidate(index);
            return true; // We've consumed the event.
        }
        return super.invokeAction(action);

    }

    class ListCallback implements ListFieldCallback {
        ListDemoScreen listDemoScreen;

        public ListCallback(ListDemoScreen listDemoScreen) {
            this.listDemoScreen = listDemoScreen;

        }

        public void drawListRow(ListField list, Graphics g, int index, int y,
                int w) {

            ChecklistData checkListData = (ChecklistData) _listElements.elementAt(index);
            String text = checkListData.getStringVal();
//          g.drawText(text, 60, y + 5, 0, w);
//          Bitmap bitm = null;
//          if(checkListData.isChecked()) {
//              bitm = Bitmap.getBitmapResource("bullet_arrow1.png");
//          } else {
//              bitm = Bitmap.getBitmapResource("bullet_arrow2.png");
//          }

//          w = bitm.getWidth();
//          int h = bitm.getHeight();
//          
//          int xpos = 2;
//          int heightDifference = ( list.getRowHeight(index) - h );
//          int ypos = y + ( heightDifference > -1 ? heightDifference : 0 ) / 2;
//
//          g.drawBitmap( xpos, ypos, w, h, bitm, 0, 0 );

//          xpos = w + 20;

            ChecklistData currentRow = (ChecklistData) this.get(list, index);

            StringBuffer rowString = new StringBuffer();

            // If it is checked draw the String prefixed with a checked box,
            // prefix an unchecked box if it is not.
            if (currentRow.isChecked()) {
                rowString.append(Characters.BALLOT_BOX_WITH_CHECK);
            } else {
                rowString.append(Characters.BALLOT_BOX);
            }

            // Append a couple spaces and the row's text.
            rowString.append(Characters.SPACE);
            rowString.append(Characters.SPACE);
            rowString.append(currentRow.getStringVal());

            // Draw the text.
            g.drawText(rowString.toString(), 0, y, 0, -1);

        }

        public Object get(ListField list, int index) {
            return _listElements.elementAt(index);
        }

        public int indexOfList(ListField list, String prefix, int string) {
            return _listElements.indexOf(prefix, string);
        }

        public int getPreferredWidth(ListField list) {
            return Display.getWidth();
        }

    }

    private class ChecklistData {
        private String _stringVal;
        private boolean _checked;

        /*
         * ChecklistData() { _stringVal = ""; _checked = false; }
         */

        ChecklistData(String stringVal, boolean checked) {
            _stringVal = stringVal;
            _checked = checked;
        }

        // Get/set methods.
        private String getStringVal() {
            return _stringVal;
        }

        private boolean isChecked() {
            return _checked;
        }


        // Toggle the checked status.
        private void toggleChecked() {
            _checked = !_checked;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.rim.device.api.ui.container.MainScreen#makeMenu(net.rim.device.api
     * .ui.component.Menu, int)
     */
    protected void makeMenu(Menu menu, int instance) {

        // TODO Auto-generated method stub
        Field focus = UiApplication.getUiApplication().getActiveScreen()
                .getLeafFieldWithFocus();
        if (focus == _checkList) {
            // The _checkList ListField instance has focus.
            // Add the _toggleItem MenuItem.
            menu.add(_toggleItem);
        }

        super.makeMenu(menu, instance);
    }

}