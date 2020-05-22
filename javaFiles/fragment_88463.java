@Override
protected void process(List<String> chunks) {
    for (String line : chunks) {
        tArea.append(line);

        if  (line.length() == 2)
        {
            char first = line.charAt(0);

            if (first == '2'
            ||  first == '4'
            ||  first == '6'
            ||  first == '8')
            {
                try
                {
                    int offset = tArea.getDocument().getLength() - 2;
                    tArea.getHighlighter().addHighlight(offset, offset + 1, DefaultHighlighter.DefaultPainter);
                } catch (BadLocationException err) {System.out.println(err);}
            }
        }
    }
}