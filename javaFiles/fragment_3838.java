/**
     * Listener to decide between showing right-click menu OR calling Preview Item after double clicking a row
     */
    private void setListenerForItemsTable() {

        tblItems.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent evt ) {
                isPreview( evt );
            }

            @Override
            public void mousePressed( MouseEvent evt ) {
                processRightClick( evt );
            }

            @Override
            public void mouseReleased( MouseEvent evt ) {
                processRightClick( evt );
            }
        } );
        itmMenu.addPopupMenuListener( new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible( PopupMenuEvent evt ) {
                processCheckbox( true );
            }

            @Override
            public void popupMenuWillBecomeInvisible( PopupMenuEvent evt ) {
                // do nothing
            }

            @Override
            public void popupMenuCanceled( PopupMenuEvent evt ) {
                processCheckbox( rightClickValue );
            }
        } );
    }

    /**
     * Checks whether a preview of the line item is warranted, and provides it
     *
     * @param evt
     */
    private void isPreview( MouseEvent evt ) {
        if ( isRow( evt ) && isDblClick( evt ) ) {
            previewItem();
        }
    }

    /**
     * Checks if the item that was clicked on was a viable table row or not
     *
     * @param evt the MouseEvent
     *
     * @return Boolean
     */
    private Boolean isRow( MouseEvent evt ) {
        return getClickedRow( evt ) >= 0;
    }

    /**
     * Checks if the click action was a double click or not
     *
     * @param evt the MouseEvent
     *
     * @return Boolean
     */
    private Boolean isDblClick( MouseEvent evt ) {
        return evt.getClickCount() == 2;
    }

    /**
     * Gets the index of the table row that was clicked on
     *
     * @param evt the MouseEvent
     *
     * @return Integer
     */
    private Integer getClickedRow( MouseEvent evt ) {
        return tblItems.rowAtPoint( evt.getPoint() );
    }

    /**
     * Bringing everything together: storing the row index and value of the checkbox, and triggering the pop-up menu
     *
     * @param evt the MouseEvent
     */
    private void processRightClick( MouseEvent evt ) {
        int row = getClickedRow( evt );
        if ( row >= 0 ) {
            rightClickRow = row;
            rightClickValue = ( Boolean.TRUE ).equals( mdlItems.getValueAt( row, model.COL_CHECK ) );
        }
        view.showMaybePopup( evt );
    }

    /**
     * Setting or unsetting the checkbox in the active row
     *
     * @param value the desired value to apply to the checkbox
     */
    private void processCheckbox( Boolean value ) {
        if ( rightClickRow >= 0 ) {
            mdlItems.setValueAt( value, rightClickRow, model.COL_CHECK );
        }
    }