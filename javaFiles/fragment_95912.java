if (dateFrom != null) {
            Instant instant = dateFrom.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            Date dateFromParam = Date.from(instant);

            q.setParameter("dateFrom", dateFromParam);
        }