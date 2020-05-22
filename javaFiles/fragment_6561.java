@Query(value = 
  "SELECT _user FROM user _user " +
  "WHERE " +
    "_user.name LIKE CONCAT('%', $1, '%') OR " +
    "_user.phone_numbers LIKE CONCAT('%', $1, '%')",
nativeQuery = true
)
List<User> findWhereNameOrPhoneNumberLike(String query);