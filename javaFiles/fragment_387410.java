final ExecutorService executor = Executors.newFixedThreadPool(3);       
@SuppressWarnings("unchecked")
final Map<String, String> outputs = (Map<String, String>)data.get(ModelConstants.EVENT_HOLDER);

for (final ModuleRegistration.ModulesHolderEntry entry : ModuleRegistration.getInstance()) {
    executor.submit(new Runnable () {
        public void run() {
            try {
                final Map<String, String> response = entry.getPlugin().process(outputs);
                //process the response and update database.
                System.out.println(map);
            } catch (Throwable e) {
                //handle execption
            } finally {
                //clean up resources
            }               
        }
    });
}