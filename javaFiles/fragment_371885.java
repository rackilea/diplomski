private void indent(int depth){
   if(depth > 0){
        System.out.print("    ");
        indent(depth-1);
    }
}
public void display() {
    System.out.print("+ " + toString() + "\n");
    for (MyTest load : attachments) {
         this.indent(this.depth);
         load.display();
    }
 }