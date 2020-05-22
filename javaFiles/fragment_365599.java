public interface JobRepository extends JobRepository<Job, Long> {
  @Query(nativeQuery = true
      , value = "SELECT "
              + "  * "
              + "FROM"
              + "  job "
              + "WHERE "
              + "  id IN "
              + "  ( "
              + "  SELECT "
              + "    jl1.job_id "
              + "  FROM "
              + "    job_language jl1 "
              + "  LEFT JOIN "
              + "    job_language jl2 "
              + "  ON "
              + "    jl1.job_id = jl2.job_id "
              + "  AND jl1.language_code = jl2.language_code "
              + "  AND jl2.language_code IN ?1 "
              + "  GROUP BY "
              + "    jl1.job_id "
              + "  HAVING "
              + "    COUNT(jl1.language_code) = COUNT(jl2.language_code) "
              + "  )")
  List<Job> findAllByLanguageCodes(String... languageCodes);
}