public class CustomTableCellRenderer extends DefaultTableCellRenderer{
    public Component getTableCellRendererComponent (JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);

        // This is your problem....
        rowidenty rowidenty1=new rowidenty();

        if (rowidenty1.tabledif) {
            cell.setBackground(Color.cyan);
        } else {
            cell.setBackground(Color.lightGray);
        }


        System.out.println(obj+"  renderer   "+column+" bool "+rowidenty1.tabledif);
        return cell;
    }
}