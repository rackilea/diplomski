public class Polynomial {

    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public void setCoef(int coeff, int exp) {
        Integer oldCoeff = map.get(exp);
        if (oldCoeff == null) oldCoeff = 0;
        map.put(exp, oldCoeff + coeff);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<Integer, Integer> e : map.descendingMap().entrySet())
            sb.append("+").append(e.getValue()).append("x^").append(e.getKey());
        return sb.substring(1);
    }

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.setCoef(3, 6);
        p1.setCoef(5, 7);
        p1.setCoef(2, 6);
        p1.setCoef(5, 8);
        System.out.println(p1); // -> 5x^8+5x^7+5x^6
    }
}