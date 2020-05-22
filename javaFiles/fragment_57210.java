public class Course {
    private Food food;

    public Course(Food food) {
        this.food = food;
    }

    public Course() {

    }

    public Food getFood() {
        return this.food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}