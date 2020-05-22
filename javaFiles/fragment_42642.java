@RestResource(path="filter", rel="filter")
@Query("select p from Product p LEFT JOIN p.role r LEFT JOIN p.vendor v where"
    + "(:vendor = '' or lower(v.name) like concat('%', lower(:vendor), '%'))"
    + "and"
    + "(:role = '' or lower(r.name) like concat('%', lower(:role), '%'))")
Page<Product> filterProduct(@Param("vendor") String vendor, @Param("role") String role);