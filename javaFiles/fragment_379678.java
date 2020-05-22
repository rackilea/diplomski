Font savedFont = oldFont;
    for (int i = 0; i < 100; i++) {
        Font newFont = new Font(oldFont.getFontName(), oldFont.getStyle(), i);
        Dimension d = getFontSize(g,newFont,text);
        if(componentSize.height < d.height || componentSize.width < d.width){
            return savedFont;
        }
        savedFont = newFont;
    }