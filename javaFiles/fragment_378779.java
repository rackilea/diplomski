public class anaBolum {
    public static void main(String[] args) {
        IMeyveler muz = new Muz();
        muz.fiyat();// Work

        ArrayList<IMeyveler> list = new ArrayList<>();
        list.add(new Muz());
        list.add(new Elma());

        Iterator<IMeyveler> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next().fiyat());
        }
    }
}