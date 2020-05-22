package com.troyware.inventoryItemManager;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;

/** 
 * This file chooser prevents users from changing file names and thus should facilitate navigating to the correct file 
 * by precluding the user from getting stuck when single clicking a folder name
 * 
 * @author http://www.mikepot.com/1493.html
 * slightly modified by Phil Troy, www.PhilTroy.com, to convert single click into double click
 */
public class MyFileChooser extends JFileChooser
{

    public MyFileChooser()
      { JList list = findFileList(this);
            for (MouseListener l : list.getMouseListeners())
            {   if (l.getClass().getName().indexOf("FilePane") >= 0)
                {   list.removeMouseListener(l);
                    list.addMouseListener(new MyMouseListener(l));
                }
            }
      }

      private JList findFileList(Component comp)
      { if (comp instanceof JList) return (JList)comp;
            if (comp instanceof Container)
            {   for (Component child : ((Container)comp).getComponents())
                {   JList list = findFileList(child);
                    if (list != null) return list;
                }
            }
            return null;
      }

      private class MyMouseListener extends MouseAdapter
      {
        MyMouseListener(MouseListener listenerChain)
        {   m_listenerChain = listenerChain;
        }


        public void mouseClicked(MouseEvent event)
        {   if (event.getClickCount() > 0)
            {   m_listenerChain.mouseClicked(new MouseEvent(event.getComponent(),  event.getID(), event.getWhen(), event.getModifiers(), event.getX(), event.getY(), 2, false)); 
            }
        }

        private MouseListener m_listenerChain;
      }

    private static final long serialVersionUID = 1L;
}