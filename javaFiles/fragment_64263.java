public class ApiResponse {

    private String kind;
    private String apiVersion;
    private Metadata metadata;
    private List<Item> items;

    public List<String> getAllNames() {
        List<String> allNames = new ArrayList();
        for (Item item: items) {
            allNames.add(item.getStatus().get(0).getName());
        }
        return allNames;
    }

    public String getFirstName() {
        if (items.length == 0 || items.get(0).getStatus().length == 0) {
            return "";
        }
        return items.get(0).getStatus().get(0).getName();
    }

    class Metadata {
        private String selfLink;
        private String resourceVersion;
    }

    class Item {
        private List<StatusContainer> status;

        List<StatusContainer> getStatus() {
            return status;
        }
    }

    class StatusContainer {
        private String name;

        String getName() {
            return name;
        }
    }
}