private  void createMinimalBST(int arr[], int start, int end, Node newNode){
    int mid = (start + end) / 2;
    newNode.key = arr[mid];

    System.out.println("new node = "+n);


    if (start <= mid-1) {
        newNode.leftChild = new Node();
        createMinimalBST(arr, start, mid - 1, newNode.leftChild);
    }
    if (mid+1 <= end) {
        newNode.rightChild = new Node();
        createMinimalBST(arr, mid + 1, end, newNode.leftChild); 
    }
    System.out.println("left child = "+ newNode.leftChild +" "+ " right child = "+ newNode.rightChild);
}