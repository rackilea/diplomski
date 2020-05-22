private void checkTreeNodes(TreeNode root) {
        if (root.getChildCount() > 0) {
            for (TreeNode children : root.getChildren()) {
                Menu menu = (Menu) children.getData();
                if (positionPrivilegesMap.containsKey(menu.getMenuid())) {
                    children.setSelected(true);
                    expand(children);
                    selectedTreeList.add(children); // --> filled with this
                }

                // recursive check
                checkTreeNodes(children);
            }
        }
    }