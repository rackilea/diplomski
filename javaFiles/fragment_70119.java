for (i = 0; !(locatedSource) && i < buttons.length;) {
        i++;
        for (j = 0; !(locatedSource) && j < buttons.length;) {
            j++;
            if (event.getSource() == buttons[i][j]) {
                locatedSource = true;
            }
        }
    }