public class JLabelObserver{
   private JLabel label;
   private Player player;
   public JLabelObserver(JLabel label, Player player){
       this.label = label;
       this.player = player;
   }
   public update(Player player){
       if(this.player.equals(player))
           label.setText(player.getAlk())
   }
}