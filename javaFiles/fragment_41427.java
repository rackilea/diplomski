int reOrderThreshold = 10;
StockItem item_1  = new StockItem("A654Y", 1000, 50, 500, 13);

int orderTravelTime = 0;
boolean orderInTravel = false;

for(int i = 0; i < 50; i++){
  //Do other things, like printing out daily demand and i
  if(orderInTravel && orderTravelTime < item_1.getLeadTime()){//If order has been ordered and has not arrived
    orderTravelTime ++;
  } else if(orderInTravel && orderTravelTime >= item_1.getLeadTime()){//If ordered and has arrived
    orderTravelTime = 0;
    orderInTravel = false;

    item_1.quantityInStock += item_1.getReOrder();
  }

  if(item_1.getQuantityInStock() < reOrderThreshold){//If stock gets to low, order
    orderInTravel = true;
  }
}