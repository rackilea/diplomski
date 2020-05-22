public ArrayList<String> wie;
public String waar;
public String wanneer;
public String wat;

public newEvent() {}

public newEvent(String waar, String wanneer, String wat, String... wie) {
    this.wie = new ArrayList<>(Arrays.asList(wie));
    this.waar = waar;
    this.wanneer = wanneer;
    this.wat = wat;
}