//Outside code
int[] arr = new int[]{0, 1, 2, 3};

// method of class
public void init(int[] arr) {
    this.arr = arr; 
}

//meanwhile, in the external code
arr[0] = 42; // this change to the array will be reflected inside the object.