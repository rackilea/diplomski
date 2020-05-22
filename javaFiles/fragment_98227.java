public Component getTableCellRendererComponent(JTable table, Object value,
              boolean isSelected, boolean hasFocus, int row, int column) {

          String str = (value == null) ? "" : value.toString();
            BufferedReader br = new BufferedReader(new StringReader(str));
            String line;
            StringBuilder sb = new StringBuilder("<HTML>");
            try {
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("<br/>");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            sb.append("</HTML>");
        super.getTableCellRendererComponent(table, sb,
                isSelected, hasFocus, row, column);
        JTableHeader tableHeader = table.getTableHeader();
        if (tableHeader != null) {
          setForeground(tableHeader.getForeground());
        }
        setIcon(getIcon(table, column));
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        return this;
      }