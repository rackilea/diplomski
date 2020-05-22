import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomJListExample extends JFrame
{

    private static final Dimension SIDE_PANEL_DIMENSION = new Dimension ( 190, 190 );
    private static final Dimension CONTAINER_PANEL_DIMENSION = new Dimension ( 400, 200 );
    private static final Dimension TEMPLATES_LIST_DIMENSION = new Dimension ( 180, 180 );
    private static final Border SIMPLE_BORDER = new JTextField ().getBorder ();

    private JList<SimpleTemplate> templatesList = new JList<> ();
    private JLabel templateName = new JLabel ();
    private JLabel templateDescription = new JLabel ();


    public CustomJListExample ()
    {
        JPanel rightPanel = prepareRightSide ();
        JPanel leftPanel = prepareLeftSide ();

        JPanel containerPanel = new JPanel ();
        containerPanel.setPreferredSize ( CONTAINER_PANEL_DIMENSION );

        containerPanel.add ( leftPanel );
        containerPanel.add ( rightPanel );
        add ( containerPanel );
        pack ();
    }

    private JPanel prepareRightSide ()
    {
        JPanel rightPanel = new JPanel ();
        rightPanel.setBorder ( SIMPLE_BORDER );
        rightPanel.setBackground ( Color.GRAY );
        rightPanel.setPreferredSize ( SIDE_PANEL_DIMENSION );

        templateName.setText ( "---" );
        templateDescription.setText ( "---" );

        rightPanel.add ( templateName );
        rightPanel.add ( templateDescription );

        return rightPanel;
    }

    private JPanel prepareLeftSide ()
    {
        JPanel leftPanel = new JPanel ();
        leftPanel.setBorder ( SIMPLE_BORDER );
        leftPanel.setBackground ( Color.GRAY );
        leftPanel.setPreferredSize ( SIDE_PANEL_DIMENSION );

        DefaultListModel<SimpleTemplate> templatesListModel = new DefaultListModel<> ();
        templatesListModel.addElement ( new SimpleTemplate ( "Template 1", "Description template 1", false ) );
        templatesListModel.addElement ( new SimpleTemplate ( "Template 2", "Description template 2", true ) );
        templatesListModel.addElement ( new SimpleTemplate ( "Template 3", "Description template 3", false ) );

        templatesList.setCellRenderer ( new JListRepositoryItem () );
        templatesList.setPreferredSize ( TEMPLATES_LIST_DIMENSION );
        templatesList.setModel ( templatesListModel );
        templatesList.repaint ();

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

        leftPanel.add ( templatesList );

        return leftPanel;
    }

    class JListRepositoryItem extends JCheckBox implements ListCellRenderer<SimpleTemplate>
    {
        @Override
        public Component getListCellRendererComponent ( JList list, SimpleTemplate value, int index,
                                                        boolean isSelected, boolean cellHasFocus )
        {
            setComponentOrientation ( list.getComponentOrientation () );
            setFont ( list.getFont () );
            setBackground ( list.getBackground () );
            setForeground ( list.getForeground () );

            setSelected ( value.isInstalled () );
            setEnabled ( list.isEnabled () );
            setText ( value.getName () );

            return this;
        }
    }

    class SimpleTemplate
    {
        private String name;
        private String description;
        private boolean installed;

        public SimpleTemplate ( String name, String description, boolean installed )
        {
            this.name = name;
            this.description = description;
            this.installed = installed;
        }

        public String getName ()
        {
            return name;
        }

        public String getDescription ()
        {
            return description;
        }

        public boolean isInstalled ()
        {
            return installed;
        }
    }

    public static void main ( String[] args )
    {
        SwingUtilities.invokeLater ( () -> new CustomJListExample ().setVisible ( true ) );
    }
}