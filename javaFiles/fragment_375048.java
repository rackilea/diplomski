String[] columnNames = {
            this.translation.getTranslation("date"), 
            this.translation.getTranslation("user"),
            this.translation.getTranslation("filename"),
            this.translation.getTranslation("filesize"),
            this.translation.getTranslation("isAccepted"),
            this.translation.getTranslation("message")
    };

    Object[][] data = new Object[this.history.size()][6];

    for (int i = 0; i < this.history.size(); i++) {
        for (int j = 0; j < 6; j++) {
            if (j == 0) data[i][j] = this.history.get(i).getDate();
            if (j == 1) data[i][j] = this.history.get(i).getUser();
            if (j == 2) data[i][j] = this.history.get(i).getFilename();
            if (j == 3) data[i][j] = this.history.get(i).getFilesize();
            if (j == 4) data[i][j] = this.history.get(i).isAccepted();
            if (j == 5) data[i][j] = this.history.get(i).getMessage();
        }
    }

    JTable table = new JTable(data, columnNames);

    this.scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
    this.add(this.scroll);