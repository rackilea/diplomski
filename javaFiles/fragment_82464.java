public class CandidateDTO {
    int total_users_count;
    List<User> users = new ArrayList<User>();
    //Set<User> users = new HashSet<User>();
}
public class User{
    String first_name;
    String email;
    String city;
    String position;
    String experience_years;
    String salary_expectations;
}