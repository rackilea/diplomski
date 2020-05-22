private static boolean hasAtLeastOneReference(Repository repo) {

    for (Ref ref : repo.getAllRefs().values()) {
        if (ref.getObjectId() == null)
            continue;
        return true;
    }

    return false;
}