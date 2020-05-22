@OneToMany(mappedBy = "parent", cascade=CascadeType.ALL, fetch=FetchType.EAGER)                           
 public List<Node> children = new LinkedList<Node>();

 @ManyToOne
 @JoinColumn(name="parent")
 public Node parent;