CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Tickets> query = builder.createQuery(Tickets.class);
            EntityType<Tickets> type = em.getMetamodel().entity(Tickets.class);
            EntityType<TicketsUpdates> typeTU = em.getMetamodel().entity(TicketsUpdates.class);
            Root<Tickets> root = query.from(Tickets.class);
            Root<TicketsUpdates> rootTicketsUpdates = query.from(TicketsUpdates.class);

            Join<Tickets,TicketsUpdates> tupdates = rootTicketsUpdates.join("tickets");