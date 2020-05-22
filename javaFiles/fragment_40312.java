while(root.data != data){  //<<<<<<root not changing
    if(data < root.data){
        search(root.left, data);
    }
    else if(data > root.data){
        search(root.right, data);
    }
}