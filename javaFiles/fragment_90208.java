class Event {
    private String playerName; 
    private int time;
    private String name;

    public Event(String eventString) {
        String[] params = eventString.split(" ");
        int i = 0;
        this.playerName = params[i++];
        if (params.length == 4) {
            this.playerName += " " + params[i++];
        }
        this.time = Integer.valueOf(params[i++]);
        this.name = params[i];
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("playerName='").append(playerName).append('\'');
        sb.append(", time=").append(time);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}