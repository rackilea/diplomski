@OneToMany(targetEntity= MarketOrderImpl.class) 
@JoinTable(name="marketorderimpl")
@MapKeyColumn(name="id")
private List<MarketOrder> sellOrders;

@OneToMany(targetEntity= MarketOrderImpl.class) 
@JoinTable(name="marketorderimpl")
@MapKeyColumn(name="id")
private List<MarketOrder> buyOrders;