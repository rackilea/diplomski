String fieldName = f.getName();
    String className = f.getDeclaringClass().getSimpleName();
    if (className.equals("Floor")) {
        if (fieldName.equals("areasList")) {
            return true;
        }

        if (fieldName.equals("parkingsList")) {
            return true;
        }
        return false;
    }