private void optimizeTableColumnWidths(XTextTable table)
throws Exception
{
    XTextViewCursorSupplier cursorSupplier = (XTextViewCursorSupplier)
            UnoRuntime.queryInterface(XTextViewCursorSupplier.class,
                    document.getCurrentController());
    XTextViewCursor viewCursor = cursorSupplier.getViewCursor();

    String cellName = "A1";
    XText cellText = (XText)UnoRuntime.queryInterface(
            XText.class, table.getCellByName(cellName));
    XTextCursor cursor = cellText.createTextCursor();

    viewCursor.gotoRange(cursor, false);
    viewCursor.gotoEnd(true);
    viewCursor.gotoEnd(true);

    XController controller = document.getCurrentController();
    XFrame frame = controller.getFrame();
    XDispatchProvider dispatchProvider = (XDispatchProvider)
        UnoRuntime.queryInterface(XDispatchProvider.class, frame);

    String unoAction = ".uno:SetOptimalColumnWidth";
    String targetFrameName = "";
    int searchFlags = 0;
    PropertyValue[] properties = new PropertyValue[0];

    dispatchHelper.executeDispatch(
            dispatchProvider,
            unoAction,
            targetFrameName,
            searchFlags,
            properties);
}