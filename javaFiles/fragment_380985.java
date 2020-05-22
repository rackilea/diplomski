@Override
public void saveEntity (Car car) {
    if (car.getId() == null) {
        entityManager.persist(car);
    } else {
        entityManager.merge(car);
    }
}