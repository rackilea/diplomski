class Output {
    private String size,
    private int limit;
    private boolean isLastPage,
    private List<Value> values;
    private int start ;
 }


class Value 
 {
     User user,
     private String permission;
 }

class User {
    private String name,
    private String emailAddress,
    private int id,
    private String displayName,
    private boolean active,
    private String slug,
    private String type
}