package com.stackoverflow.test;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
   private String         name       = "";
   private List<TreeNode> childNodes = new ArrayList<TreeNode>();

   public TreeNode(final String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public void add(final TreeNode child) {
      childNodes.add(child);
   }

   public List<TreeNode> getChildren() {
      return this.childNodes;
   }

   public static void main(String[] args) {

      TreeNode parent = new TreeNode("Parent");

      TreeNode childA = new TreeNode("ChildA");
      childA.add(new TreeNode("GrandChildA"));

      TreeNode childB = new TreeNode("ChildB");
      childB.add(new TreeNode("GrandChildB"));

      parent.add(childA);
      parent.add(childB);

      TreeNode.printRecursively(parent, 0);
   }

   private static void printRecursively(final TreeNode root, final int level) {
      if (null != root && null != root.getChildren()) {

         for (int i = 0; i < level; ++i) {
            System.out.print("   ");
         }

         System.out.println(root.getName());

         for (TreeNode child: root.getChildren()) {
            TreeNode.printRecursively(child, level + 1);
         }
      }
   }

}