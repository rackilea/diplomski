@Entity
@Table(uniqueConstraints=
           @UniqueConstraint(columnNames = {"name", "type"}) 
public Foo {
    @Id
    private Long id;
    @Column
    private String name;
    @Column    
    private String type;

    ...
}