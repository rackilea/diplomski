@ManyToOne()
@JoinColumn(nullable = false, name = "commenterId")
public User getCommenter()
{
    return commenter;
}