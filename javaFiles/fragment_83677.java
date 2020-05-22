@Entity
   @Table(name = "table_name")
   class NewEntity {

    //Id and anothers fields

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notifications notifications ;

    //getters and setters       
}