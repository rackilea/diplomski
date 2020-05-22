while (me.getParent() != null) {
        me = me.getParent();
        Permission[] permissions = me.getPermission();
        if (permissions != null) {
            for (Permission p : permissions) {
                // do stuff....
            }
        }
    }