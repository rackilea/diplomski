public class Mail {

private Integer id;
private Othersomething data;

@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="user_id" , referencedColumnName="your foreign key here in Account table")
@Column(insertable=false, updatable=false)
private Account account;

}