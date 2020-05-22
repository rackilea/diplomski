List<ELDDutyLog> activeSalesOrders = salesOrders.stream()
        .filter(so -> so.getStatus() == RecordStatus.ACTIVE)
        .collect(Collectors.toList());

for (int i = 0; i < activeSalesOrders.size() - 1; i++) {
    activeSalesOrders.get(i).setActiveDurationMinutes(
                    Minutes.minutesBetween(
                        activeSalesOrders.get(i).getStartTime(),
                        activeSalesOrders.get(i+1).getStartTime()
                    ).getMinutes()
                );
}