public void insert(RadixNode root, Customer customer){
    insert_with_name(root, customer, 0);
    insert_with_phone_nb(root, customer, 0);
}

public void insert_with_name(RadixNode node, Customer customer, int idx){
    if (idx == customer.getName().length()){
        node.setCustomer(customer);
    } else {
        Character current_char = customer.getName().chatAt(idx);
        if (! node.getChlidren().containsKey(current_char){
            RadixNode new_child = new RadixNode();
            node.getChildren().put(current_char, new_child);
        }
        insert_with_name(node.getChildren().get(current_char), customer, idx+1);
    }
}