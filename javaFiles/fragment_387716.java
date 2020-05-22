public class KeyCouple {   

    private String name;    

    private String pwd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyCouple keyCouple = (KeyCouple) o;
        return Objects.equals(name, keyCouple.name) &&
                Objects.equals(pwd, keyCouple.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pwd);
    }
}