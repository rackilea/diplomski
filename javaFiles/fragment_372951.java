public class Thanos{
    public static void main(String[] args){
        Avengers avengers = new Thanos.Avengers();
        Avengers.StarLord starLord = avengers.new StarLord();
        starLord.getGamora();
    }
    static class Avengers{
        private class StarLord{
            private void getGamora(){
                System.out.println("Access me to get a soul for a soul.");
            }
        }
    }
}