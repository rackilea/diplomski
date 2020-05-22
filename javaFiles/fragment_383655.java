class Pair<X,Y>{

    private X first;
    private Y second;

    Pair(X first,Y second){
        this.first=first;
        this.second=second;
    }

    public X getX() {
        return first;
    }

    public void setX(X first) {
        this.first = first;
    }

    public Y getY() {
        return second;
    }

    public void setY(Y second) {
        this.second = second;
    }


    public Comparator<Pair<X, Y>> getComparator(){
        return new Comparator<Pair<X, Y>>() {

            @Override
            public int compare(Pair<X, Y> o1, Pair<X, Y> o2) {
                double a=(Double) o1.getY();
                double b=(Double) o2.getY();
                if(a==b){
                    return 0;
                }else if(a>b){
                    return 1;
                }else{
                    return -1;
                }
            }
        };
    }

}

public class Main{

    public static void main(String[] arg){

        List<Pair<String,Double>> val1 = new ArrayList<Pair<String,Double>>();

        val1.add(new Pair<String,Double>("f\u2081(1) = ", 0.1));
        val1.add(new Pair<String,Double>("f\u2082(1) = ", 0.2));
        val1.add(new Pair<String,Double>("f\u2083(1) = ", 0.1));
        val1.add(new Pair<String,Double>("f\u2084(1) = ", 1.1));
        val1.add(new Pair<String,Double>("f\u2085(1) = ", 1.2));
        val1.add(new Pair<String,Double>("f\u2086(1) = ", 2.0));
        val1.add(new Pair<String,Double>("f\u2087(1) = ", 2.1));
        val1.add(new Pair<String,Double>("f\u2088(1) = ", 0.3));

        Collections.sort(val1,new Pair<String,Double>("",0.0).getComparator());

        for (Pair<String, Double> pair : val1) {
            System.out.println(pair.getX()+" "+pair.getY());
        }
    }
}