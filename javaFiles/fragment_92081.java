return JPA.withTransaction(
                "default",
                false, () -> {
                    String sid = getSidFromCookie(ctx);
                    if (sid != null) {
                        Session appSession = (Session) JPA.em().createNamedQuery("Session.findBySessionId").getSingleResult();
                        User user = appSession.getUserId();
                        if (user != null) {
                            ctx.args.put("user", user);
                            return delegate.call(ctx);
                        }
                    }
                    Result unauthorized = Results.unauthorized("Invalid Session");
                    return F.Promise.pure(unauthorized);
                }
        );