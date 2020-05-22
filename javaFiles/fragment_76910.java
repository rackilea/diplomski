public class MyRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

            if(node.getUserObject().getYourProperty()){
                 setTextNonSelectionColor(Color.BLACK);
                 setBackgroundSelectionColor(Color.BLUE);
                 setTextSelectionColor(Color.WHITE);
                 setBorderSelectionColor(Color.WHITE);
            }
           else{
                 setTextNonSelectionColor(Color.LIGHT_GRAY);
                 setBackgroundSelectionColor(Color.RED);
                 setTextSelectionColor(Color.WHITE);
                 setBorderSelectionColor(Color.WHITE);
           }

            super.getTreeCellRendererComponent(
                tree, value, sel, exp, leaf, row, hasFocus);
            return this;
        }
}