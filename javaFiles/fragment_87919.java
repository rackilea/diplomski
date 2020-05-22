public class PlayerData
{
    private ItemID id;
    private ClientHome home;
    private ClientAvatar avatar;
    private Instant creationDate;
    private int sessionCount;
    private int playTimeSeconds;
    private int daysSinceStart;
    private int startupCooldown;

    public ItemID getId()
    {
        return id;
    }
    public void setId(ItemID id)
    {
        this.id = id;
    }
    public ClientHome getHome()
    {
        return home;
    }
    public void setHome(ClientHome home)
    {
        this.home = home;
    }
    public ClientAvatar getAvatar()
    {
        return avatar;
    }
    public void setAvatar(ClientAvatar avatar)
    {
        this.avatar = avatar;
    }
    public Instant getCreationDate()
    {
        return creationDate;
    }
    public void setCreationDate(Instant creationDate)
    {
        this.creationDate = creationDate;
    }
    public int getSessionCount()
    {
        return sessionCount;
    }
    public void setSessionCount(int sessionCount)
    {
        this.sessionCount = sessionCount;
    }
    public int getPlayTimeSeconds()
    {
        return playTimeSeconds;
    }
    public void setPlayTimeSeconds(int playTimeSeconds)
    {
        this.playTimeSeconds = playTimeSeconds;
    }
    public int getDaysSinceStart()
    {
        return daysSinceStart;
    }
    public void setDaysSinceStart(int daysSinceStart)
    {
        this.daysSinceStart = daysSinceStart;
    }
    public int getStartupCooldown()
    {
        return startupCooldown;
    }
    public void setStartupCooldown(int startupCooldown)
    {
        this.startupCooldown = startupCooldown;
    }
}