public static void main(String[] args) {
    OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
            .getOperatingSystemMXBean();

    while (true) {
        System.out.println(bean.getProcessCpuLoad());
        System.out.println(bean.getSystemCpuLoad());
    }

}