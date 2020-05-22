public class UserEntity {

// other mappings for id,username,firstName,lastName here

 @Formula("nullif(concat(firstname,' ',lastname),' ')") // firstname and lastname are column names
 private String fullName;
}