Files.lines(Paths.get("files", "programList.txt")).forEach(
            f -> {
                JLabel label = new JLabel(f);
                label.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        executeopeningMagicWithTheFile(f);
                    }
                });
                panel.add(label);
            }
    );