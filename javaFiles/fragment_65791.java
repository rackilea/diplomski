enum Colour {
    BLACK, WHITE;

    Colour toggle() {
        if (this.equals(BLACK))
            return WHITE;
        else
            return BLACK;
    }
}