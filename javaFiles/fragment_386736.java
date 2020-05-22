txtLog = new JTextArea(10, 30); // changed
        txtLog.setLineWrap(true);
        getContentPane().add(txtLog);

        tasks = new ArrayList<PanelTaskProgress>();

        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setPreferredSize( txtLog.getPreferredSize() ); // added