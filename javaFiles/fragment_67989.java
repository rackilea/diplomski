class GooiDobbelsteen extends MouseAdapter {

   @Override
   public void mouseClicked(MouseEvent e) {
      aanBeurt = false;
      dobbelsteen = new Random();
      aantalogen = dobbelsteen.nextInt(6) + 1;
      aantalOog = String.valueOf(aantalogen);
      Dobbelsteen dobbel = new Dobbelsteen(Spel.this); // !!
      dobbel.aantalOgen(aantalogen);