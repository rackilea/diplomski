if (currentTime > 0 && currentTime < 25) {
    hourlyData = weatherAPI.HourlyReport(currentTime);
    setHourlyData();
} else {
    System.out.println("Oops");
}