com.hazelcast.core.IMap<String, Customer> distributedMap = Hazelcast.getMap("customers");
distributedMap.addEntryListener(new EntryListener() {
        public void entryAdded(EntryEvent entryEvent) {
            System.out.println("Entry added");
        }

        public void entryRemoved(EntryEvent entryEvent) {
            System.out.println("Entry removed");
        }

        public void entryUpdated(EntryEvent entryEvent) {
            System.out.println("Entry updated");
        }

        public void entryEvicted(EntryEvent entryEvent) {
            System.out.println("Entry evicted");
        })