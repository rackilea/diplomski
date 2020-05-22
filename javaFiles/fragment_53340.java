public class Column extends ArrayList {}
List deck = Cards.createNewDeck();
Column[] columns = new Column[10];
int c = 0;

for (int i = 0; deck.size() > 50; i = (i+1)%10)
{
  if (columns[i] == null)
    columns[i] = new Column();

  columns[i].add(Cards.dealTopCard(deck));
}