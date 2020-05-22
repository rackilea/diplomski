public class Plant {

    int leaves;
    int age;
    //int sumLeaves;  you do not need them now, as the averageLeaves method is static
    //double average;

    static void averageLeaves (int leaves1, int leaves2) {

        int sumLeaves = leaves2 + leaves1;               //here is where I need help
        double average = (double) sumLeaves / 2;
        System.out.println("The average number of leaves is: " + average);
    }

    void setLeaves(int leaves){
        this.leaves = leaves;
    }

    int getLeaves(){
        return this.leaves;
    }
}

    public class Main {

    public static void main(String[] args) {

        Plant plantA = new Plant();
        plantA.setLeaves(5);

        Plant plantB = new Plant();
        plantB.setLeaves(3);

        Plant.averageLeaves(plantA.getLeaves(), plantB.getLeaves());
    }
}