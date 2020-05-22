@SuppressWarnings("unused")
@Repository
public interface KotizacijeCjenovnikRepository extends 
    JpaRepository<KotizacijeCjenovnik, BigInteger> {
    @Query(value="select kotizacije_cjenovnik from KotizacijeCjenovnik kotizacije_cjenovnik where kotizacije_cjenovnik.kotizacija = :kotizacija")
    List<KotizacijeCjenovnik> getKotizacijeByKotizacija(@Param("kotizacija") Kotizacija kotizacija);
}