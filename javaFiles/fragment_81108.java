public static class RelationShip {
    public static final int FRIEND = 0;
    public static final int ENEMIE = 1;
    public static final int FAMILY = 2;

    ...

    }

public class Contact {
    private int relationshipType;

    ...

    public void setRelationShipType(int relationShip) {

    }

    public boolean areWeFriends() {
        if (relationshipType==Relationship.FRIEND)
            return true;
        else
            return false;
    }

    ...
}