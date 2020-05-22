//Order entity
@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
private List<Items> items;

//item entity
@ManyToOne
@Column(name = "order_fk")
private Order order;

//Return entity
@OneToMany(mappedBy = "return")
private List<Items> items;

//item entity
@ManyToOne
@Column(name = "return_fk")
private Return return;