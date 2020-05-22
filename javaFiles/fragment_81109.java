public enum RelationShip {
    FRIEND, ENEMIE, FAMILY
    }

public class Contact {
    private RelationShip relationshipType;

    public void setRelationShipType(RelationShip relationShip) {
        ...
    }

    public boolean areWeFriends() {
        if (relationshipType==Relationship.FRIEND)
            return true;
        else
            return false;
    }
}