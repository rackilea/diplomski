public static int search(Node root,String data) { 
    while(!root.isNullLeaf) {    
        String temporary=root.data;
        if(temporary.equalsIgnoreCase(data)) {
            System.out.print("yaaay "+ root.data +" is found\n");
            return 0;
        }
        int compareResult = temporary.compareToIgnoreCase(data);
        if(compareResult > 0)
            root = root.left;
        else
            root = root.right;   
    }
    System.out.println("ouch "+ data+ " not found\n");
    return 1;
}