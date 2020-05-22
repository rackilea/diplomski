synchronized public Child checkChild(Child child) {
    try {
        if (child != null) {
            tempSession = getSessionFactory().openSession();
            Child tempChild = (Child) tempSession.bySimpleNaturalId(Child.class).load(Child.getMd5Hash());
            if (tempChild != null) {
                return tempChild;
            } else {
                return child;
            }
        } else {
            return null;
        }
    } catch (Exception ex) {
        return null;
    }
    finally{
        tempSession.close();
    }
}