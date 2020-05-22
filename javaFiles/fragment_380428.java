Files.lines(Paths.get("src/main/files/end.log")).forEach( (p) ->
        chart.computeIfPresent(p.substring(0,2), (k, v) -> {
            try {
                v.setEndTime(p.substring(3));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        //return value for key p.substring(0,2)
        }));