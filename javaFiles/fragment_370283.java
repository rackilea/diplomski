public class Bean {
    private List<Entity> entities;
    private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();

    public void submit() {
        for (Entity entity : entities) {
            if (checked.get(entity.getId())) {
                // Entity is checked. Do your thing here.
            }
        }
    }

    // ...
}