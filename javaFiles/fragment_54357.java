class GameClass {
    private final Dao dao;

    GameClass(Dao dao) { this.dao = dao; }

    void gameMethod() {
         Car car = new Car();
         dao.save(car);
    }

}