public class Item {

    private int id;
    private String username;


    public Item(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (obj instanceof Item) {
            Item temp = (Item) obj;
            if (this.id == temp.id)
                return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub

        return (this.id.hashCode() + this.username.hashCode());
    }
}