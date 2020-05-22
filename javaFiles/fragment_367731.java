Path<Flight> statePath = queryRoot.get("flightDate.dateState"); // or queryRoot.get("flightDate").get("dateState"): to be tested
Path<Flight> valuePath = queryRoot.get("flightDate.value");
Order[] orders;
if (isAscending()) {
    orders = new Order[] {criteriaBuilder.asc(valuePath), criteriaBuilder.asc(statePath)  };
}
else {
    orders = new Order[] {criteriaBuilder.desc(valuePath), criteriaBuilder.desc(statePath)  
}

query.orderBy(orders);