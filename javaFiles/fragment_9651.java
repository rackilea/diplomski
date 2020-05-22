public boolean isPair(int playerIndex, char charToIgnore) {
        boolean isPair = false;

        if (hasSameRank(playerAndHand[playerIndex])) {
            isPair = true;
        } else {
            for (int i = 0; i < TABLE_CARDS_LENGTH; i++) {
                if (tableCards[i].charAt(1) == charToIgnore) continue;
                for (int j = 0; j < HAND_CARDS_LENGTH; j++) {                        
                    if (playerAndHand[playerIndex][j].charAt(1) == tableCards[i].charAt(1)) {
                        isPair = true;
                        break;
                    }
                }
                if (isPair) break; 
            }
        }
        return isPair;
    }

public char isThreeOfKind(int playerIndex) {
        boolean isThreeOfKind = false;
        char cardValue = '';

        // 2 from player hand 1 from table
        if (hasSameRank(playerAndHand[playerIndex])) {
            for (int i = 0; i < TABLE_CARDS_LENGTH; i++) {
                if (playerAndHand[playerIndex][0].charAt(1) == tableCards[i].charAt(1)) {
                    cardValue = tableCards[i].charAt(1);
                    isThreeOfKind = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < TABLE_CARDS_LENGTH; i++) {
                // first card in player hand and 2 more on table
                if (playerAndHand[playerIndex][0].charAt(1) == tableCards[i].charAt(1)) {
                    for (int j = 0; j < TABLE_CARDS_LENGTH; j++) {
                        if (j != i) {
                            if (playerAndHand[playerIndex][0].charAt(1) == tableCards[j].charAt(1)) {
                                cardValue = tableCards[j].charAt(1);
                                isThreeOfKind = true;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    if (isThreeOfKind) break;
                    // second card in player hand and 2 more on table   
                } else if (playerAndHand[playerIndex][1].charAt(1) == tableCards[i].charAt(1)) {
                    for (int j = 0; j < TABLE_CARDS_LENGTH; j++) {
                        if (j != i) {
                            if (playerAndHand[playerIndex][1].charAt(1) == tableCards[j].charAt(1)) {
                                cardValue = tableCards[j].charAt(1);
                                isThreeOfKind = true;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    if (isThreeOfKind) break;
                }                   
            }
        }
        return cardValue;
    }