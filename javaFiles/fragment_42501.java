LocalTime start = LocalTime.parse(timeStart);
        LocalTime stop = LocalTime.parse(timeStop);
        if (stop.isAfter(start)) { // the normal situation
            System.out.println(formatDuration(Duration.between(start, stop)));
        } else if (stop.equals(LocalTime.MIDNIGHT)) {
            System.out.println(
                    formatDuration(Duration.between(start, stop).plusDays(1)));
        } else {
            System.out.println("End time " + timeStop + " was before start time " + timeStart);
        }