public class Cooldown {
    private float cooldownTime = 0;
    private float length = 0;
    private Action action;

    public Cooldown(float length, Action action) {
        this.length = length;
        this.action = action;
    }

    public boolean update(float delta) {
        // Subtract the delta until we hit 0
        this.cooldownTime = this.cooldownTime - delta <= 0 ? 0 : this.cooldownTime - delta;
        // The boolean tells you that the cooldown has expired- useful for special effects
        return this.cooldownTime == 0;
    }

    public void execute() {
        if(this.cooldownTime > 0) return;
        this.cooldownTime = this.length;
        this.action.execute();
    }

    public interface Action {
        void execute();
    }
}