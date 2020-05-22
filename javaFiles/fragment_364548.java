@Override
public boolean onContactAdded(btCollisionObject ob0, int partId0, int index0, btCollisionObject ob1, int partId1, int index1) {
    AbstractObject aO0 = (AbstractObject) ob0.userData;
    AbstractObject aO1 = (AbstractObject) ob1.userData;


    dispatcher.handleCollision(aO0, aO1);
    // dispatcher.handleCollision(aO1, aO0); // if you want to do both

    return true;
}