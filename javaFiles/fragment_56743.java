public class LoginDetails implements Comparable<LoginDetails>{
    //...        

    @Override
    public int compareTo(LoginDetails another) {
        return uName.compareTo(another.uName);
    }

    //...