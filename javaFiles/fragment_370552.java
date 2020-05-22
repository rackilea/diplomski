public enum A {
    THIS("2","4"), IS("4","7"), REAL("12.5","29");

    private final String optionOne;
    private final String optionTwo;

    A(String optionOne, String optionTwo){
        this.optionOne= optionOne;
        this.optionTwo= optionTwo;
    }

    public String getOptionOne(){
        return optionOne;
    }

    public String getOptionTwo(){
        return optionTwo;
    }   
}

public void test() {
    System.out.println(A.valueOf("THIS").getOptionOne()+ " - "+A.valueOf("THIS").getOptionTwo());
}