public class ZombieListener implements Listener {

    private final List<String> entities;

    public ZombieListener(List<String> entities){
        this.entities = entities;
    }

    @EventHandler
    public void onEntityTargetEvent(EntityTargetLivingEntityEvent event) {
        if (event.getTarget() instanceof Player && entities.contains(event.getEntityType().getName())) {
            final Player targeted = (Player) event.getTarget();
            if (targeted.hasPermission("dont.target.me") && entities.contains(targeted)) {
                event.setCancelled(true);
            }
        }
    }
}