public interface YourDto {
  // all Mentor get fields
  String getFirstName();
  ...
  // activeStudents get field
  Integer getActiveStudents();
}

public interface YourRepository extends JpaRepository<YourEntity, Integer> {
  @Query(value = "select ...(all fields match YourDto) from Mentor m, MentorStudents s where m.id = s.mentorId and m.id = ?1")
  Optional<YourDto> findMyDto(Integer mentorId);
}