public class CollisionListener extends ContactListener {

    @Override
    public boolean onContactAdded(btCollisionObject ob0, int partId0, int index0, btCollisionObject ob1, int partId1, int index1) {
        AbstractObject aO0 = (AbstractObject) ob0.userData;
        AbstractObject aO1 = (AbstractObject) ob1.userData;

        aO0.dispatchCollision(aO1);
        //aO1.dispatchCollision(aO0); // if you want to do both

        return true;
    }
}