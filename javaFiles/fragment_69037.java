import java.util.Objects;

public class Auth {
    private String uuid;
    private String name;
    private int bits;
    private String gang;
    private String rank;

    public Auth() {
    }

    public Auth(String uuid, String name, int bits, String gang, String rank) {
        this.uuid = uuid;
        this.name = name;
        this.bits = bits;
        this.gang = gang;
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Auth)) {
            return false;
        }
        Auth auth = (Auth) o;
        return Objects.equals(uuid, auth.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "Auth{" +
            "uuid='" + uuid + '\'' +
            ", name='" + name + '\'' +
            ", bits=" + bits +
            ", gang='" + gang + '\'' +
            ", rank='" + rank + '\'' +
            '}';
    }
}