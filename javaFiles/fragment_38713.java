@Connect(ScrollTable.class)
public class ScrollTableConnector extends TableConnector implements
        ScrollHandler {

    private VScrollTable dependentPane = null;

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        super.updateFromUIDL(uidl, client);
        String tableId = uidl.getStringAttribute("dependentTable");
        if (tableId == null) {
            return;
        }
        if (dependentPane == null) {
            FocusableScrollPanel scrollBody = (FocusableScrollPanel) getWidget()
                    .getWidget(1);
            scrollBody.addScrollHandler(this);
        }
        dependentPane = ((TableConnector) client.getConnector(tableId, 0))
                .getWidget();
    }

    @Override
    public void onScroll(ScrollEvent event) {
        FocusableScrollPanel scrollBody = (FocusableScrollPanel) getWidget()
                .getWidget(1);
        FocusableScrollPanel scrollToBeBody = (FocusableScrollPanel) dependentPane
                .getWidget(1);
        scrollToBeBody.setScrollPosition(scrollBody.getScrollPosition());
    }
}