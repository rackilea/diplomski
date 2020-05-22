for owners{
 for cards with card.ownerID = owners.ID{
   card.balance=card.balance-payments ;
   card.balance=card.balance+calcInterest(card.balance, card.rate)+GetSumOfFees(card);
   }
}