public class FamilyNode {
    // ...
    // ...
    public void traverseNode(){
       if(name.equals("NameWeAreLookingFor")){
          // We found a node named "NameWeAreLookingFor"
          // return here if your are not interested in visiting children
       } 
       for(FamilyNode child : node.children){
            child.traverseNode();
       }
    }
}