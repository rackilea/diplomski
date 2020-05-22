public List<Car> findAll() {
    List<Car> carsList = new ArrayList<Car>();
    try {
        query = session.createQuery("from Car");
        carsList = query.list();
        for (Iterator iterator = carsList.iterator(); iterator.hasNext(); ) {
            Car car = (Car) iterator.next();
        }
    } catch (HibernateException he) {
        he.printStackTrace();
    } finally {

    }
    return carsList;
}