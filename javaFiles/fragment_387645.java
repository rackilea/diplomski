this.jdbcTemplate.update("UPDATE GCUR_OBSERVATION "
                + "SET ObserverId = ?," + "ObservationDate = ?,"
                + "PointCuring = ?"
                + " WHERE locationId = ? AND ObservationStatus = 0",
                new Object[] { new Integer(newObservation.getObserverId()),
                        newObservation.getObservationDate(),
                        locId) });