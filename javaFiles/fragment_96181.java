String[] lines = content.split("\n");
      int linesCount = 0;
            for (int i = 0; i < lines.length; i++) {
                linesCount++;
                linesCount += metrics.stringWidth(lines[i]) / (jTextArea.getColumns() * columnWidth);
            }
      jTextArea.setRows(linesCount);