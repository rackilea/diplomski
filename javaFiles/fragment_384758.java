@Entity
@Table(name = "table_name")
class NewEntity {

    //Id and anothers fields

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    //getters and setters       
}