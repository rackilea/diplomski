public class User{
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    public List<APost> aPosts;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    public List<BPost> bPosts;
}

public class BPost extends Post {

    @ManyToOne(fetch=FetchType.LAZY)    
    public User user;
}

public class APost extends Post {

     @ManyToOne(fetch=FetchType.LAZY) 
     public User user;
}