class TreeNode  

    {


     String name





     /**
      * This method deletes a node and all the relations that are bound to this node.
      * @return
      */
     def deleteNode() {

      // delete all child relations
      def myChildren = getChildren()
      println "myChildren: "+myChildren*.name

      myChildren.each { child ->
       println "child: "+child.name
       removeFromChildren(child)
      }

      // delete all parent relations
      def myParents = getParents()
      println "myParents: "+myParents*.name
      myParents.each { parent ->
       println "parent: "+parent.name
       removeFromParents(parent)
      }


      delete(flush:true)
     }


     TreeSet<TreeNode> getChildren() {
       TreeNodeChild.executeQuery("select tnc.child from TreeNodeChild tnc where tnc.node = :node", [node: this])
     }


     TreeNode removeFromChildren(TreeNode child) {
      TreeNodeChild.findByNodeAndChild(this, child).delete(flush: true)
      this
     }

     /**
      * Add a node as type (i.e. child) to another node.
      * @param child
      * @return
      */
     TreeNode addToChildren(TreeNode child) {
      TreeNodeChild tnc = new TreeNodeChild(node: this, child: child)
      if (tnc.validate()) {

       if (!isCyclic(child, "type")) {
        println ">>>>>>>> no cycle"
        tnc.save(flush: true)
       }
       else {
        println ">>>>>>>> !!!!!!! cycle found"
       }
      }
      this
     }


     TreeSet<TreeNode> getParents() {
      TreeNodeChild.executeQuery("select tnc.node from TreeNodeChild tnc where tnc.child = :child", [child: this])
     }

     TreeNode removeFromParents(TreeNode parent) {
      TreeNodeChild.findByNodeAndChild(parent, this).delete(flush: true)
      this
     }

     TreeNode addToParents(TreeNode parent) {
      TreeNodeChild tnc = new TreeNodeChild(node: parent, child: this)
      if (tnc.validate()) {

       if (!parent.isCyclic(this, "type")) {
        println ">>>>>>>> no cycle"
        tnc.save(flush: true)
       }
       else {
        println ">>>>>>>> !!!!!!! cycle found"
       }
      }
      this
     }







     private boolean isCyclic(node) {
      boolean cyclic = false
      def myParents = this.getParents()

      // if there are parents of this node
      if (myParents.size() != 0) {

       // if the new node is in the parents set of this node
       if (myParents.contains(node)) {
        cyclic = true
        return cyclic
       }
       else {
        // go into each parent of this node and test if new node is contained in their parents
        myParents.each { parent ->
         if (cyclic) {
          return cyclic
         }
         cyclic = parent.isCyclic(node)
        }
       }
      }

      return cyclic
     }





    }