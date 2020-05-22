public interface ListingRepository extends JpaRepository<Listing, Long> {

    @EntityGraph(attributePaths = { "listingAttachments" }) 
    @Query("SELECT l FROM Listing l JOIN l.listingAttachments a 
        WHERE l.id = (:id) and l.deleteFlag = 0 and a.deleteFlag = 0")
    public Listing findOneWithImagesAndAttachments(@Param("id") Long id);

}