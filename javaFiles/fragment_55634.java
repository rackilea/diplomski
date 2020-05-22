templatesList.addMouseListener ( new MouseAdapter ()
{
    @Override
    public void mousePressed ( final MouseEvent e )
    {
        final Point point = e.getPoint ();
        final int index = templatesList.locationToIndex ( point );
        if ( index != -1 )
        {
            // Next calculations assume that text is aligned to left, but are easy to adjust
            final SimpleTemplate element = templatesList.getModel ().getElementAt ( index );
            final Rectangle cellBounds = templatesList.getCellBounds ( index, index );
            final JListRepositoryItem renderer = ( JListRepositoryItem ) templatesList.getCellRenderer ();
            final int iconWidth = renderer.getIcon () !=null ? renderer.getIcon ().getIconWidth () : 16;
            final Insets insets = renderer.getInsets ();
            final int iconX = cellBounds.x + insets.left;

            // Ensure that mouse press happened within top/bottom insets
            if ( cellBounds.y + insets.top <= point.y && point.y <= cellBounds.y + cellBounds.height - insets.bottom )
            {
                // Check whether we hit the checkbox icon
                if ( iconX <= point.x && point.x <= cellBounds.x + insets.left + iconWidth )
                {
                    // We hit the checkbox icon
                    element.installed = !element.installed;
                    templatesList.repaint ( cellBounds );
                }
                else
                {
                    // Check whether we hit text
                    final int iconTextGap = renderer.getIconTextGap ();
                    final int textX = cellBounds.x + insets.left + iconWidth + iconTextGap;
                    final FontMetrics fontMetrics = renderer.getFontMetrics ( renderer.getFont () );
                    final int textWidth = fontMetrics.stringWidth ( element.getName () );
                    if ( textX <= point.x && point.x <= textX + textWidth )
                    {
                        // We hit the text
                        templateName.setText ( element.getName () );
                        templateDescription.setText ( element.getDescription () );
                    }
                    else
                    {
                        // Reset values
                        templateName.setText ( "---" );
                        templateDescription.setText ( "---" );
                    }
                }
            }
            else
            {
                // Reset values
                templateName.setText ( "---" );
                templateDescription.setText ( "---" );
            }
        }
        else
        {
            // Reset values
            templateName.setText ( "---" );
            templateDescription.setText ( "---" );
        }
    }
} );