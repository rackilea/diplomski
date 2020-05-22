public interface MessagesRepository extends CrudRepository<Message, Long> { 

    @Query("Select m from Message m join fetch m.sender ms join fetch m.receiver mr where ms.id = :senderId or mr.id = :receiverId order by m.time desc")
    List<Message> findBySenderIdOrReceiverIdOrderByTimeDesc(Long senderId, Long receiverId);

}