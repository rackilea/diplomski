import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class Snippet {

   public static void main( String[] args ) {
      final Display display = new Display();
      Shell shell = new Shell(display);
      shell.setLayout(new FillLayout());
      final Tree tree = new Tree(shell, SWT.BORDER);
      tree.setHeaderVisible(true);
      TreeColumn col1 = new TreeColumn(tree, 0);
      col1.setText("col1");
      TreeColumn col2 = new TreeColumn(tree, 0);
      col2.setText("col2");

      for ( int i = 0; i < 4; i++ ) {
         TreeItem iItem = new TreeItem(tree, 0);
         iItem.setText(new String[] { "TreeItem (0) -" + i, "x" });
         for ( int j = 0; j < 4; j++ ) {
            TreeItem jItem = new TreeItem(iItem, 0);
            jItem.setText(new String[] { "TreeItem (1) -" + i, "x" });
            for ( int k = 0; k < 4; k++ ) {
               TreeItem kItem = new TreeItem(jItem, 0);
               kItem.setText(new String[] { "TreeItem (2) -" + i, "x" });
               for ( int l = 0; l < 4; l++ ) {
                  TreeItem lItem = new TreeItem(kItem, 0);
                  lItem.setText(new String[] { "TreeItem (3) -" + i, "x" });
               }
            }
         }
      }

      col1.pack();
      col2.pack();

      Listener listener = new Listener() {

         @Override
         public void handleEvent( Event e ) {
            final TreeItem treeItem = (TreeItem)e.item;
            display.asyncExec(new Runnable() {

               @Override
               public void run() {
                  for ( TreeColumn tc : treeItem.getParent().getColumns() )
                     tc.pack();
               }
            });
         }
      };

      tree.addListener(SWT.Collapse, listener);
      tree.addListener(SWT.Expand, listener);

      shell.setSize(200, 200);
      shell.open();
      while ( !shell.isDisposed() ) {
         if ( !display.readAndDispatch() ) display.sleep();
      }
      display.dispose();
   }
}