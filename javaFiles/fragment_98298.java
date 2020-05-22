@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    OrderEntity findByUUID(@Param("uuid") String uuid);

    List<OrderEntity> findByInProduction(@Param("inProduction") Boolean inProduction);
}