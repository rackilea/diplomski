interface ICardAttack {
      public int getAttack();
   }

   class CardUnit extends Card implements ICardAttack {
      private int attack; 
      @Override
      public int getAttack() { return attack; }
    }