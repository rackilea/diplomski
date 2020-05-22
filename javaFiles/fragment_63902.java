for (int i = 0; i < size - 1; i++) {
    for (int j = 0; j < size; j++) {
        final Line line = new Line(shell, SWT.NONE);
        lines[i] = line;

        line.setBounds(100 + i * 35,54 + j * 13,32,11);

        line.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseUp(final MouseEvent e) {
                line.setEnabled(false);
                line.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));

                ... 
            }
        });

    }
}