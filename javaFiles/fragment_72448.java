@Transactional
public interface PostDao extends CrudRepository<Post, Long>{

@Query(getAllPostsByRank)
List<Post> getAllPostsByRank(Pageable pageable);

final String getAllPostsByRank= "from Post order by value DESC";
}