DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) {

        File[] tmp = dir.listFiles();
        Vector<File> ol = new Vector<File>();
        ol.addAll(Arrays.asList(tmp));
        Collections.sort(ol, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {

                int result = o1.getName().compareTo(o2.getName());

                if (o1.isDirectory() && o2.isFile()) {
                    result = -1;
                } else if (o2.isDirectory() && o1.isFile()) {
                    result = 1;
                }

                return result;
            }
        });
        // Pass two: for files.
        for (int fnum = 0; fnum < ol.size(); fnum++) {
            File file = ol.elementAt(fnum);
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
            if (file.isDirectory()) {
                addNodes(node, file);
            }
            curTop.add(node);
        }
        return curTop;
    }