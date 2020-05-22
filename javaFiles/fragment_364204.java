public interface MeasurementRepository extends CrudRepository<Measurement, Long> {

    @Query(value = "SELECT date, f1, precison, recall " +
          "FROM measurement " +
          "LEFT JOIN measurement_data_points ON measurement.id = measurement_data_points.measurement_id " +
          "LEFT JOIN measurement_point ON measurement_data_points.data_points_id = measurement_point.id WHERE name='identifiedNeed';", nativeQuery = true)
    List<Measurement> findAllMeasurementDataPoints();
}