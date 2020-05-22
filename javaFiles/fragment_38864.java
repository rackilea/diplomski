public class Cards
{
    private ArrayList<cards> deck; 

    public static enum cards
    {
        D_A, D_2, D_3, D_4, D_5, D_6, D_7, D_8, D_9, D_10, D_J, D_Q, D_K,
        H_A, H_2, H_3, H_4, H_5, H_6, H_7, H_8, H_9, H_10, H_J, H_Q, H_K,
        C_A, C_2, C_3, C_4, C_5, C_6, C_7, C_8, C_9, C_10, C_J, C_Q, C_K,
        S_A, S_2, S_3, S_4, S_5, S_6, S_7, S_8, S_9, S_10, S_J, S_Q, S_K,
    }

    public Cards()
    {
        deck = new ArrayList<cards>(51);
        for (cards card : cards.values())
        {
            deck.add(card);
        }
        Collections.shuffle(deck);
        String img = deck.get(2).toString()+".gif";     
        System.out.println(img);
    }
    public ArrayList <cards> getDeck() {
        return deck;
    }
    public static void main(String[] args)
    {
        Cards CardDeck = new Cards();
    }
}