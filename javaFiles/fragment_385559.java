public boolean isDuplicateEntry(String email) {
        Session session = getSession();
        try {
            User user = (User) session.get(User.class, email);
            session.close();

            return (null != user);

        } catch (RuntimeException e) {
            log.error("get failed", e);
            session.close();
            throw e;
        }
    }