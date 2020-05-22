for(String s:list){
            String[] substr=s.split("\\.");
            String parent=substr[0];
            for(int i=1;i<substr.length-1;i++){
                parent=parent+ "." + substr[i];
            }
            DefaultMutableTreeNode node=null;
            node=findparentnode(parent,root);


            if(node==null)
                root.add(new DefaultMutableTreeNode(s));
            else
                node.add(new DefaultMutableTreeNode(s));

        }