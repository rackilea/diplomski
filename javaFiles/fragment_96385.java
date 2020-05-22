public class SelectionFrame extends JFrame
{
    Font name;
    Font title;

    public SelectionFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
    }

    public JMenuBar createMenuBar()
    {
        JMenuBar menuBar;
        JMenu m_file;
        JMenuItem mi_save;
        JMenuItem mi_load;

        JMenu m_edit;
        JMenuItem mi_tileHeight;
        JMenuItem mi_tileWidth;

        menuBar = new JMenuBar();
        m_file = new JMenu("File");
        m_edit = new JMenu("Edit");

        mi_save = new JMenuItem("Save file", KeyEvent.VK_S);
        mi_load = new JMenuItem("Load file", KeyEvent.VK_L);
        mi_tileHeight = new JMenuItem("Set tile height",
        KeyEvent.VK_H);
        mi_tileWidth = new JMenuItem("Set tile width",
        KeyEvent.VK_W);

        menuBar.add(m_file);
        m_file.add(mi_save);
        m_file.add(mi_load);

        menuBar.add(m_edit);
        m_edit.add(mi_tileHeight);
        m_edit.add(mi_tileWidth);

        return menuBar;
    }

    public void main( String args[] )
    {

        SelectionFrame sel = new SelectionFrame();
        sel.setLocationRelativeTo(null);
        sel.setSize(400 + (sel.getInsets().left + > sel.getInsets().right), 400
        + (sel.getInsets().top + sel.getInsets().bottom));

        sel.setTitle("Tiles/Meta");
        sel.setResizable(false);
        sel.setFocusable(true);

        sel.getContentPane().add( new JLabel( "Content", SwingConstants.CENTER),
         BorderLayout.CENTER );
        sel.setLocation(sel.getX() - (sel.getWidth() / 2), sel.getY() - >             (sel.getHeight() / 2));
        sel.setVisible(true);

    }
}