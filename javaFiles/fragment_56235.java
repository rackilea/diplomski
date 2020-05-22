public Class getColumnClass(int column)
        {
            if(column == table.convertColumnIndexToView(1))
            {
                return Number.class;
            }

            if(column == table.convertColumnIndexToView(2))
            {
                return JPanel.class;
            }

            return super.getColumnClass(column);

        }