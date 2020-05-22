private synchronized void onChildCheckChange()
    {
        if (getChildrenCount() == 0) {
            return;
        }

        long childrenCheckNum = 0;
        for (FileTree child : children.values()) {
            if (child.isChecked) {
                ++childrenCheckNum;
            }
        }

        /* Uncheck parent only if don't left selected children nodes */
        isChecked = childrenCheckNum > 0;

        /* Sending check change event up the parent */
        if (parent != null && parent.isChecked() != isChecked) {
            parent.onChildCheckChange();
        }
    }