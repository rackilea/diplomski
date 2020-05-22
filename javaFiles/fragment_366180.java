return analytics.reports().query()
                .setIds("channel==" + id)
                .setStartDate("2018-11-29")
                .setEndDate("2018-12-01")
                .setMetrics("views")
                .setDimensions("day")
                .execute();