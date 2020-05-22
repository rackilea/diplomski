while (!(locatedSource) && i < buttons.length) {
        i++;
        while (!(locatedSource) && j < buttons.length) {
            j++;
            if (event.getSource() == buttons[i][j]) {
                locatedSource = true;
            }
        }
    }