public class OpenDemo extends javax.swing.JFrame implements ChangeListener
{
private ArrayList<OInternalFrame> frames = new ArrayList<OInternalFrame>();
private OInternalFrame currentFrame;
private DropTargetListener dropListner;
int i=0;
JTabbedPane tabbedPane2;
public OpenDemo() {
  initComponents();
}
@SuppressWarnings("unchecked")
private void initComponents() {
dropListner=new DropTargetListener();
currentFrame=new OInternalFrame("doc1",true,true);
tabbedPane2=new JTabbedPane();
this.add(tabbedPane2);
enableDragAndDrop();
tp = new javax.swing.JTabbedPane();
jMenuBar1 = new javax.swing.JMenuBar();
jMenu1 = new javax.swing.JMenu();
open = new javax.swing.JMenuItem();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
jMenu1.setText("File");
open.setText("Open");
open.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        openActionPerformed(evt);
    }
});
jMenu1.add(open);
jMenuBar1.add(jMenu1);
setJMenuBar(jMenuBar1);
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
);
layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tp, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE));
pack();
 }

private void openActionPerformed(java.awt.event.ActionEvent evt) {
FileDialog fd = new FileDialog(OpenDemo.this, "Select File", FileDialog.LOAD);
fd.setVisible(true);
String sts;
if (fd.getFile() != null) {
    sts = fd.getDirectory() + fd.getFile();
    System.out.println(sts);
    BufferedReader br = null;
    StringBuffer str = new StringBuffer("");
    try {
        br = new BufferedReader(new FileReader(sts));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                str.append(line + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(OpenDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(OpenDemo.class.getName()).log(Level.SEVERE, null, ex);
    }
    String t = str.toString();
    OInternalFrame internalFrame = new OInternalFrame("",true,true);
    i++;
    internalFrame.setName("Doc "+i);
    // Should file name here
    internalFrame.setName(fd.getFile());
    DropTarget target=new DropTarget(internalFrame.textArea,dropListner);
    try {
        internalFrame.setSelected(true);
    } catch (PropertyVetoException ex) {
        Logger.getLogger(OpenDemo.class.getName()).log(Level.SEVERE, null, ex);
    }
    internalFrame.addInternalFrameListener(new InternalFrameAdapter() {
        @Override
        public void internalFrameClosing(InternalFrameEvent e) {
            i--;
            frames.remove(currentFrame);
            tp.remove(currentFrame);
        }
    });
    tp.add(internalFrame);
    tp.setSelectedIndex(i-1);
    tp.addChangeListener(this);
    frames.add(internalFrame);
    currentFrame=internalFrame;

    currentFrame.setText(t);
    currentFrame.setVisible(true);
}
}
@Override
public void stateChanged(ChangeEvent ce) {
JTabbedPane sourceTabbedPane = (JTabbedPane) ce.getSource();
int index = sourceTabbedPane.getSelectedIndex();
try {
    currentFrame =frames.get(index);
}
catch(IndexOutOfBoundsException e1){
}
}
public static void main(String args[]) {
try {
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
 } catch (ClassNotFoundException ex) {
    java.util.logging.Logger.getLogger(OpenDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
    java.util.logging.Logger.getLogger(OpenDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
    java.util.logging.Logger.getLogger(OpenDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(OpenDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new OpenDemo().setVisible(true);
    }
});
}
 private javax.swing.JMenu jMenu1;
 private javax.swing.JMenuBar jMenuBar1;
 private javax.swing.JMenuItem open;
 private javax.swing.JTabbedPane tp;
 private void enableDragAndDrop() {
 DropTarget target=new DropTarget(this,dropListner);
 }

 private class DropTargetListener implements java.awt.dnd.DropTargetListener
 {
 public void dragEnter(DropTargetDragEvent e) {
 }
 public void dragExit(DropTargetEvent e) {
 }
 public void dragOver(DropTargetDragEvent e) {
 }
 public void dropActionChanged(DropTargetDragEvent e) {
 }
 public void drop(DropTargetDropEvent e) {
 try {
    e.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
    java.util.List list=(java.util.List)e.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
    File file=(File)list.get(0);
    OInternalFrame newOInternalFrame=new OInternalFrame(file.getName(),true,true);
    DropTarget target=new DropTarget(newOInternalFrame.textArea,dropListner);
    newOInternalFrame.textArea.read(new FileReader(file),null);
    // currentFrame.textArea.read(new FileReader(file),null);
    newOInternalFrame.textArea.setCaretPosition(0);
    // currentFrame.textArea.setCaretPosition(0);
    //tabbedPane2.add(add(newTabTextArea));
    tp.add(newOInternalFrame);
    int tabIndex=tp.indexOfComponent(newOInternalFrame);
    tp.setSelectedIndex(tabIndex);
    tp.setTitleAt(tabIndex,file.getName());
    add(tp);
}
catch(Exception ex){}
}
}
}