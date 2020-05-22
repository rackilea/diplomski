@Entity
public class FollowingRelationship {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
@JoinColumn(name = "owner_id")
SomeUser owner;

@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
@JoinColumn(name = "follower_id")
SomeUser follower;

...

@Entity
public class Product {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@ManyToOne()
@JoinColumn(name = "owner_id")
private SomeUser owner;

@Column
private String name;

...

@Entity
public class SomeUser {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@Column
private String name;

@OneToMany(mappedBy = "owner")
private Set<Product> products = new HashSet<Product>();

@OneToMany(mappedBy = "owner")
private Set<FollowingRelationship> ownedRelationships = new HashSet<FollowingRelationship>();

@OneToMany(mappedBy = "follower")
private Set<FollowingRelationship> followedRelationships = new HashSet<FollowingRelationship>();