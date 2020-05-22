@Override
public Vehicle insertVehicle(Vehicle vehicle) {

    entityManager.getTransaction().begin();
    vehicle = entityManager.merge(vehicle);
    entityManager.getTransaction().commit();
    return vehicle;
}