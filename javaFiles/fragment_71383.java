@Entity
@DiscriminatorValue("DOCUMENT")
public class SharedDocument extends Share { 
    @ManyToOne
    @JoinColumn( name="DOCUMENT_ID", nullable=true )
    private Document document;
    ....

}

@Entity
@DiscriminatorValue("POST")
public class SharedPost extends Share {
    @ManyToOne
    @JoinColumn( name="POST_ID", nullable=true )
    private Post post;
    ....

}