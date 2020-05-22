private void handleBackspace(IDocument d, DocumentCommand c) {
        if (c.offset == -1 || d.getLength() == 0)
            return;
        int p = (c.offset == d.getLength() ? c.offset - 1 : c.offset);
        IRegion info;
        try {
            info = d.getLineInformationOfOffset(p);
            String line = d.get(info.getOffset(), info.getLength());
            int lineoffset = info.getOffset();
            /*Make sure unindent is made only if user is indented and has caret in correct position */
            if ((p-lineoffset+1)%4==0&&((line.startsWith("    ") && !line.startsWith("     ")) || (line.startsWith("        ") && !line.startsWith("         ")))){ //1 or 2 level fixed indent
                c.offset-=3;
                c.length=4;
            }

        }catch (org.eclipse.jface.text.BadLocationException e) {
            e.printStackTrace();
        }
    }