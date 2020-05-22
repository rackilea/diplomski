public void sendTopToBottom() {

    if (!isEmpty()){
        sendToBottom(pop());
    }

}

private void sendToBottom(E victim){
    if (isEmpty()){
        push(victim);
    } else {
        E temp = pop();
        sendToBottom(victim);
        push(temp);
    } 
}