@Override
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            Component c = super.prepareRenderer(renderer, row, column);
            JComponent jc = (JComponent) c;
            if (!isRowSelected(row))
            {
                c.setBackground(getRowBackground(row));
            }

            return c;
        }

        private Color getRowBackground(int row)
        {
            boolean isDark = true;

            Object previous = getValueAt(0, 7);

            for (int i = 1; i <= row; i++)
            {
                Object current = getValueAt(i, 7);

                if (! current.equals(previous))
                {
                    isDark = !isDark;
                    previous = current;
                }
            }

            return isDark ? Color.ORANGE : Color.YELLOW;
        }