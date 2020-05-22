public Card(String suit, String value) {
    this.suit = suit;
    switch(value) {
        case "Ace":
            isAce = true; // conditional logic req'd since Ace can be 1 or 11.
            break;
        case "Jack":
        case "Queen":
        case "King":
            this.value = 10;
            break;
     }
     this.cardName = value;
}