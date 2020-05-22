@Repository
public interface SmsLogRepository extends JpaRepository<SmsLog, Long> {

@Query(value = "select * from sms_log s where s.phone_number = (:ph) \n#pageable\n", countQuery = "select count(*) from sms_log s where s.phone_number = (:ph) \n#pageable\n", nativeQuery = true)
Page<SmsLog> findByPhoneNumber(@Param("ph") String phoneNumber, Pageable pageable);

@Query(value = "select * from sms_log s where s.phone_number = (:ph) AND s.message_timestamp between (:fromdate) and (:todate) \n#pageable\n",countQuery = "select count(*) from sms_log s where s.phone_number = (:ph) AND s.message_timestamp between (:fromdate) and (:todate) \n#pageable\n", nativeQuery = true)
Page<SmsLog> findByPhoneNumberAndDate(@Param("ph") String phoneNumber, @Param("fromdate") String fromDate, @Param("todate") String todate, Pageable pageable);

@Query(value = "select * from sms_log s where s.message_timestamp between (:fromdate) and (:todate) \n#pageable\n",countQuery = "select count(*) from sms_log s where s.message_timestamp between (:fromdate) and (:todate) \n#pageable\n", nativeQuery = true)
Page<SmsLog> findByDate(@Param("fromdate") String fromDate, @Param("todate") String todate, Pageable pageable);
}