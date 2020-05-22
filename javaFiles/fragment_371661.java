public interface PostRepository extends JpaRepository<Post, Integer> {

    @Override
    @EntityGraph(attributePaths = {"postDetail"})
    Page<Post> findAll(Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {"postDetail"})
    List<Post> findAll();
}