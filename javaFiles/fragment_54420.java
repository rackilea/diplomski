import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class PicSlider2 {
    private JButton thumbs;
    private JButton[] thumbnails;
    private JLabel picViewer;
    private JPanel thumbPanel;
    private JToolBar toolBar;
    private int scrollIndex;
    private final JFrame frame;
public PicSlider2() {
    scrollIndex = 0;
    frame = new JFrame("Picture Slider");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(800, 600));
    frame.setResizable(false);
    frame.setLayout(new BorderLayout());

    picViewer = new JLabel();
    picViewer.setText("Image here");
    picViewer.setHorizontalAlignment(JLabel.CENTER);
    picViewer.setVerticalAlignment(JLabel.BOTTOM);
    picViewer.setBorder(new LineBorder(Color.BLACK, 2));

    JMenuBar frameMenuBar = new JMenuBar();
    frame.setJMenuBar(frameMenuBar);
    JMenu file = new JMenu("File");
    frameMenuBar.add(file);

    JMenuBar picViewerMenu = new JMenuBar();
    picViewerMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
    thumbs = new JButton("THUMBNAILS");//an icon in actual program
    thumbs.setPreferredSize(new Dimension(150,45));
    thumbs.setToolTipText("Thumbnails");
    thumbs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                picViewer.setVisible(false);
                thumbPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,20));                
                thumbPanel.setBorder(BorderFactory.createEmptyBorder(50,100,50,30));

                thumbnails = new JButton[30];//example size, chosen so all buttons won't fit on one page
                for (int i = 0; i < 30; i++) {
                    thumbnails[i] = new JButton(Integer.toString(i));
                    thumbnails[i].setPreferredSize(new Dimension(100, 100));                  
                    thumbnails[i].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {                           
                                System.out.println("thumbnail clicked - opens full-size view of pic in the JLabel picViewer");                                  
                            }
                        }); 
                    thumbPanel.add(thumbnails[i]);
                    thumbPanel.setVisible(true); 
                }
                toolBar = new JToolBar(null, JToolBar.VERTICAL);
                toolBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 30));
                JButton up = new JButton("Up Arrow");
                up.setPreferredSize(new Dimension(80,60));
                up.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {  
                            System.out.println("Up Arrow Stub - NEEDS TO SCROLL UP PAGE, as needed");
                            if(scrollIndex > 3) scrollIndex -= 4;
                            else scrollIndex = 0;
                            reloadThumbs();
                        }
                    } );
                JButton down = new JButton("Down Arrow");
                down.setPreferredSize(new Dimension(80,60));
                down.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {  
                            System.out.println("Down Arrow Stub - NEEDS TO SCROLL DOWN PAGE, as needed");
                            if(scrollIndex < 27) scrollIndex += 4;
                            else scrollIndex = 30;
                            reloadThumbs();
                        }
                    } );
                toolBar.add(Box.createGlue());
                toolBar.add(up);
                toolBar.add(Box.createVerticalStrut(40));
                toolBar.add(down);
                toolBar.add(Box.createGlue());
                frame.getContentPane().add(thumbPanel, BorderLayout.CENTER);
                frame.getContentPane().add(toolBar, BorderLayout.LINE_END);
            }
        });
        picViewerMenu.add(thumbs);
        frame.getContentPane().add(picViewerMenu, BorderLayout.SOUTH);
        frame.add(picViewer, BorderLayout.CENTER);
        frame.setLocation(300, 50);
        frame.pack();
        frame.setVisible(true);
    }

    private void reloadThumbs(){
        thumbPanel.removeAll();
        for(int i = scrollIndex; i < 30; ++i){
            thumbPanel.add(thumbnails[i]);
        }
        for(int i = 0; i < scrollIndex; ++i){
            thumbPanel.add(thumbnails[i]);
        }
        thumbPanel.revalidate();            
        frame.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    PicSlider2 ps = new PicSlider2();
                }
            });
    }
}