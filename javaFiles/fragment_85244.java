.filter(new GenericSelector<SecureUser>() {
                    @Override
                    public boolean accept(SecureUser u) {
                        return u == null || u.getChatSessionIds() == null || u.getChatSessionIds().isEmpty();
                    }
                })