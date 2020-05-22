public class LoadCpuSolve {

        static void complexСalculation() {
            // Complexs calculations here...
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static Object getValue(MBeanServer server, ObjectName name,
            String attrName) throws ReflectionException, InstanceNotFoundException {
            AttributeList attrs =
                server.getAttributes(name, new String[]{attrName});

            Object value = null;
            if (!attrs.isEmpty()) {
                Attribute att = (Attribute) attrs.get(0);
                value = att.getValue();
            }

            return value;
        }

        public static void main(
            String... args) throws Exception
            complexСalculation();

            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            ObjectName
                name = ObjectName.getInstance("java.lang:type=OperatingSystem");

            System.out.println(
                "While method execute, process CPU load on " + getValue(server, name,
                       "ProcessCpuLoad"));
            System.out.println(
                "While method execute, process CPU time on " + getValue(server, name,
                        "ProcessCpuTime"));
            System.out.println(
                "While method execute, system CPU load on " + getValue(server, name,
                        "SystemCpuLoad"));
        }
   }