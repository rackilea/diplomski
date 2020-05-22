if (users != null) {
                for (User f : users) {
                    UserView fv = new UserView(f);
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(fv);
                    root.add(node);
                }
            }