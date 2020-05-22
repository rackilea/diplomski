class Person {
    private int weight;
    private int age;
    private int height;
    private boolean isASmoker;
    private boolean isMale;
    private boolean isGoodLooking;
    private boolean isAbleToRelocate;

    public Person(int weight, int age, int height, boolean isASmoker, boolean isMale, boolean isGoodLooking, boolean isAbleToRelocate) {
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.isASmoker = isASmoker;
        this.isMale = isMale;
        this.isGoodLooking = isGoodLooking;
        this.isAbleToRelocate = isAbleToRelocate;
    }

    public boolean isGood() {
        return weight < 160 && age <= 27 && age >= 22 && 
               height < 72 && !isASmoker && isMale && 
               isGoodLooking && isAbleToRelocate;
               // (variable == true) => variable
               // (variable == false) => !variable
    }

    public static void main(String[] args) {
        Person person = new Person(150, 24, 71, false, true, true, true);
        System.out.println(person.isGood() ? "Marry Me!" : "Get Lost!");
    }
}