public Card searchHand(Card[] h, Card.rank r)
 {
    for (int i = 0; i < h.length; i++)
    {
        if (h[i].rank == r)
            return h[i];
        else if (i == h.length - 1)
            return null;
    }
 }