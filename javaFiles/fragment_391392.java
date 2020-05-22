private static Map<TimeUnit, Long> computeDiff(Date start, Date end) {
            long diffMilTime = end.getTime() - start.getTime();
            List<TimeUnit> units = new ArrayList<>(EnumSet.allOf(TimeUnit.class));
            Collections.reverse(units);

            Map<TimeUnit, Long> result = new LinkedHashMap<>();
            long restMilTime = diffMilTime;
            for (TimeUnit unit : units) {
                long diff = unit.convert(restMilTime, TimeUnit.MILLISECONDS);
                long diffInMilliesForUnit = unit.toMillis(diff);
                restMilTime = restMilTime - diffInMilliesForUnit;
                result.put(unit, diff);
            }
            return result;
        }