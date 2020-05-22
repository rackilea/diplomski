public String toString() {
      String cardValue = "";
      String rank = "";
      String suit = "";
      switch (aSuit) {
        case HEARTS:
          suit = "hearts";
          break;
        case DIAMONDS:
          suit = "diamonds";
          break;
        case CLUBS:
          suit = "clubs";
          break;
        case SPADES:
          suit = "spades";
          break;
      }

    switch (aRank) {
      case ACE:
        rank = "Ace";
        break;
      case TWO:
        rank = "2";
        break;
      case THREE:
        rank = "3";
        break;
      case FOUR:
        rank = "4";
        break;
      case FIVE:
        rank = "5";
        break;
      case SIX:
        rank = "6";
        break;
      case SEVEN:
        rank = "7";
        break;
      case EIGHT:
        rank = "8";
        break;
      case NINE:
        rank = "9";
        break;
      case TEN:
        rank = "10";
        break;
      case JACK:
        rank = "Jack";
        break;
      case QUEEN:
        rank = "Queen";
        break;
      case KING:
        rank = "King";
        break;
    }
    cardValue += rank + " of " + suit;
    return cardValue;
  }