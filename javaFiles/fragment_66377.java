private Map<Object, Color> rowColor = new HashMap<Object, Color>();
        private Color nextColor = Color.ORANGE;

        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            Component c = super.prepareRenderer(renderer, row, column);
            JComponent jc = (JComponent) c;

            if (isRowSelected(row)) return c;

            Object value = table.getValueAt(row, 7);
            Color background = rowColor.get(value);

            if (background != null)
            {
                c.setBackground( background );
            }
            else
            {
                rowColor.put(value, nextColor);
                c.setBackground( nextColor );
                nextColor = (nextColor == Color.ORANGE) ? Color.YELLOW : Color.ORANGE;
            }

            return c;
        }