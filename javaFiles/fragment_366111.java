class Roasterplayers {
    String lastUpdatedOn;
    List<PlayerEntry> playerentry;
}


class PlayerEntry {
    Player player;
    Team team;
}

class Player {

    @JsonProperty("ID")
    String id;
    @JsonProperty("LastName")
    String lastName;
    @JsonProperty("FirstName")
    String firstName;
}

class Team {
    @JsonProperty("ID")
    String id;
    @JsonProperty("City")
    String city;
    @JsonProperty("Name")
    String name;
    @JsonProperty("Abbreviation")
    String abbreviation;
}