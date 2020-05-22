@Repository
public class BenchDaoCustomImpl implements BenchDaoCustom {

    @PersistenceContext
    private EntityManager em;

    public void deleteBench(Long benchId) {
        this.em.createNativeQuery("UPDATE TF_BENCH SET ISDELETED = 1, SEQ = (select CASE WHEN (min(BENCH.SEQ) < 1) THEN (min(BENCH.SEQ)-1) ELSE -1 END from TF_BENCH BENCH WHERE BENCH.STAGE = (select BENCH.STAGE from TF_BENCH BENCH WHERE id =?0)) WHERE id =?0")
            .setParameter(0, benchId)
            .executeUpdate();
    }
}