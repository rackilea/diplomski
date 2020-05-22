package com.xxemu.main;
import java.awt.Menu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Techni extends JInternalFrame
{

    private static final long serialVersionUID = -7905672790566329537L;
    static int openFrameCount = 0;
    private ImageIcon image;
    private JLabel label;
    private Menu menu;
    public int frame = 1;
    static final int xOffset = 75, yOffset = 90;

    public Techni()
    {
        super("emu",
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
        //setSize(783, 522);
        setSize(400, 400);

        setLocation(xOffset, yOffset);
    }

    public void setLayeredPane(JLayeredPane layered)
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("asdfsd");
                if (e.getX() < 0 && e.getY() > 0)
                {
                    System.out.println("test");
                }

            }
        });
    }
}