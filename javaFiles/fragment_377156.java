if ("Analyze Text File".equals(command)) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                String text = sb.toString();
                Map<Integer, Integer> counts = getCounts(text);
                int width = counts.size() * BAR_WIDTH;
                int max = maxCount(counts);
                int height = max * INCREMENT + 100;
                int horizon = height - 25;
                HistogramPanel panel = new HistogramPanel(width, counts, height, horizon);
                JOptionPane.showMessageDialog(null, panel);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }