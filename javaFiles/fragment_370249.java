@Transactional
public interface Rank extends CrudRepository<RankArticle, Identity> {

    @Modifying
    @Query(value = "INSERT INTO rank" +
                        "(SELECT id, shop_id, SUM(sales) AS score, CAST(NULL AS INT) AS rank " +
                        "FROM " +
                            "(SELECT id, shop_id, sales FROM daily_pod " +
                            "WHERE shop_id = :shopId " +
                            "UNION " +
                            "SELECT id, shop_id, sales FROM weekly_pod " +
                            "WHERE shop_id = :shopId " +
                            "UNION " +
                            "SELECT id, shop_id, sales FROM end_pod " +
                            "WHERE shop_id = :shopId) " +
                        "AS pods " +
                        "GROUP BY id, shop_id ORDER BY score DESC LIMIT :limit) " +
                "ON CONFLICT (id) DO UPDATE " +
                "SET shop_id = EXCLUDED.shop_id, score = EXCLUDED.score, " +
                    "rank_count = EXCLUDED.rank_count;"
        , nativeQuery = true)
void calcScore(@Param("shopId") Integer shopId,
               @Param("limit") Integer limit);