Map<String, Arraylisttableitem> map = new HashMap<String, Arraylisttableitem>();
for(Arraylisttableitem item : tableStatusList){
    Arraylisttableitem prevItem = map.get(item.getTab_name());
    if(prevItem != null){
        prevItem.setTotal(String.valueOf(Integer.parseInt(item.getTotal()) + Integer.parseInt(prevItem.getTotal())));
        prevItem.setBalance(String.valueOf(Integer.parseInt(item.getBalance()) + Integer.parseInt(prevItem.getBalance())));
        prevItem.setNoofcustomer(String.valueOf(Integer.parseInt(item.getNoofcustomer()) + Integer.parseInt(prevItem.getNoofcustomer())));
        prevItem.setTime(String.valueOf(Integer.parseInt(item.getTime()) + Integer.parseInt(prevItem.getTime())));
        map.put(item.getTab_name(), prevItem);
    } else {
        map.put(item.getTab_name(), item);
    }
}       
tableStatusList = new ArrayList<Arraylisttableitem>(map.values());