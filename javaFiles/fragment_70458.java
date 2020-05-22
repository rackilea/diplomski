public class A {

    private int number;

    A(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + number;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        A other = (A) obj;
        if (number != other.number)
            return false;
        return true;
    }

    public static void main(String[] args) {
        A a1 = new A(5);
        A a2 = new A(5);

        System.out.println(a1.equals(a2));
    }


}