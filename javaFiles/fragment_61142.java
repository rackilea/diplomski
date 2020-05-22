public class PlayerKills {
private UUID playerUUID;
private int kills;

public PlayerKills(UUID uuid) {
    this.playerUUID = uuid;
}
public void addkill() {
    this.kills++;
}
public int getKills() {
    return this.kills;
}
}