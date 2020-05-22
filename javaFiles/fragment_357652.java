@Query("SELECT C FROM Message C " +
       "WHERE 1=1 " +
       "AND ((1=:#{ #param1 == null ? 1 : 0 }) OR (C.param1 = :#{#param1})) " +
       "AND ((1=:#{ #param2 == null ? 1 : 0 }) OR (C.param2 = :#{#param2})) " +
       "AND ((1=:#{ #param3 == null ? 1 : 0 }) OR (C.param3 = :#{#param3})) " +
       "AND ((1=:#{ #param4 == null ? 1 : 0 }) OR (C.param4 = :#{#param4})) "
)
List<Message> find(@Param("param1") Long param1, @Param("param2") Long param2,@Param("param3") Long param3, @Param("param4") Long param4);