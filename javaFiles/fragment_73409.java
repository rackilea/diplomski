class APIResponse{

   @SerializedName("users")
   @Expose
   private List<User> users;

  public List<User> getUsers()
   {return users;}

  public void setUsers(List<User> users)
   {this.users= users;}

}