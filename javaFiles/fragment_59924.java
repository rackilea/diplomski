public void search_by_name(RadixNode node, String name, int idx){
    // returns NULL if there is no user going by that name
    if (idx == name.length()){
        return node.getCustomer();
    } else {
        Character current_char =  name.chatAt(idx);
        if (! node.getChlidren().containsKey(current_char){
            return NULL;
        } else {
            return search_by_name(node.getChildren().get(current_char), name, idx+1);
        }
    }
}