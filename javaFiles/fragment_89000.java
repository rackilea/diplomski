void run(){
      Obj root = new Obj(1);
      root = insertVal(root, 4);
      root = insertVal(root, 7);
      root = insertVal(root, 9);
      root = insertVal(root, 12);
      root = insertVal(root, 13);
      root = insertVal(root, 43);
      root = insertVal(root, 45);
      System.out.println(floor(root, 15));
 }

 // throws a RuntimeException if there is no smaller value in the BST.
 int floor(Obj root, int val){
     int ans = Integer.MIN_VALUE;
     boolean found = false;
     while(root != null){
         if(root.val==val){
             return val;
         }
         if(val < root.val){
             root = root.left;
         }else{
            found = true;
             ans = root.val;
             root = root.right;
         }
     }
     if(!found){
        throw new RuntimeException("There is no smaller value than " + val + " in the BST");
     }
     return ans;
 }

 Obj insertVal(Obj root, int val){
     if(root==null){
         return new Obj(val);
     }
     if(val < root.val){
         root.left = insertVal(root.left, val);
     }else{
         root.right = insertVal(root.right, val);
     }
     return root;
 }
}
class Obj{
 int val;
 Obj right;
 Obj left;

 public Obj(int val){
      this.val = val;
      right = left = null;
 }

 public String toString(){
      return val + " ";
 }
}