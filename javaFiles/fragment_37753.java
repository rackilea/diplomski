String searchKey = "hello";
    String content = styledText.getText(); // StyledText instance
    int index = content.indexOf(searchKey, 0);
    do {
        if (index != -1) {
            StyleRange styleRange = new StyleRange(index, searchKey.length(), Display.getCurrent().getSystemColor(
                    SWT.COLOR_BLACK), Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));
            styledText.setStyleRange(styleRange);
            index = content.indexOf(searchKey, index + 1);
        } else {
            System.out.println("End of search");
            break;
        }

    } while (index != -1);