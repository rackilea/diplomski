private void printVmsCpuUtilizationAndPowerConsumption() {
    for (Vm vm : vmList) {
        System.out.println("Vm " + vm.getId() + " at Host " + vm.getHost().getId() + " CPU Usage and Power Consumption");
        double vmPower; //watt-sec
        double utilizationHistoryTimeInterval, prevTime = 0;
        final UtilizationHistory history = vm.getUtilizationHistory();
        for (final double time : history.getHistory().keySet()) {
            utilizationHistoryTimeInterval = time - prevTime;
            vmPower = history.powerConsumption(time);
            final double wattsPerInterval = vmPower*utilizationHistoryTimeInterval;
            System.out.printf(
                "\tTime %8.1f | Host CPU Usage: %6.1f%% | Power Consumption: %8.0f Watt-Sec * %6.0f Secs = %10.2f Watt-Sec\n",
                time, history.vmCpuUsageFromHostCapacity(time) *100, vmPower, utilizationHistoryTimeInterval, wattsPerInterval);
            prevTime = time;
        }
        System.out.println();
    }
}