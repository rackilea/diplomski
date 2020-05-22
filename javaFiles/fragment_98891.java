private  void createMinimalBST(int arr[], int start, int end){
    int mid = (start + end) / 2;
    this.key = arr[mid];

    System.out.println("new node = "+n);


    if (start <= mid-1) {
        this.leftChild = new Node();
        this.leftChild.createMinimalBST(arr, start, mid - 1);
    } 
    if (mid+1 <= end) {
        this.rightChild = new Node();
        this.rightChild.createMinimalBST(arr, mid + 1, end); 
    } 
    System.out.println("left child = "+ newNode.leftChild +" "+ " right child = "+ newNode.rightChild);
}