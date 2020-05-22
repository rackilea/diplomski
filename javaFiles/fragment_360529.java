public class FruitPool extends GenericPool<Sprite> {
// ===========================================================
// Constants          
// ===========================================================

// ===========================================================          
// Fields         
// =========================================================== 
private ITextureRegion[] mTextureRegions = new ITextureRegion[5];
private Scene mScene;
private int mCount;
// ===========================================================          
// Constructors          
// =========================================================== 
public FruitPool(final ITextureRegion watermelonRegion, ITextureRegion cherryRegion,ITextureRegion mBallTextureRegion, ITextureRegion grapeTextureRegion, ITextureRegion strawberryTextureRegion,Scene attachedScene) {
    this.mTextureRegions[0] = watermelonRegion;
    this.mTextureRegions[1] =cherryRegion;
    this.mTextureRegions[2]= mBallTextureRegion;
    this.mTextureRegions[3]= grapeTextureRegion;
    this.mTextureRegions[4] = strawberryTextureRegion;
    this.mScene = attachedScene;
}
// ===========================================================          
// Getter & Setter          
// =========================================================== 

// ===========================================================          
// Methods for/from SuperClass/Interfaces          
// ===========================================================  
@Override
protected Sprite onAllocatePoolItem() {
    //This method is called internally by GenericPool<T> class.
    //It is called when the pool is out of items, so a new one should be allocated.
    //Remember - you MUST create a new item here! Don't return a reference to an existing one.
    int fruitPos = MathUtils.random(0, 4);
    final Sprite fruit = new Sprite(0, 0, this.mTextureRegions[fruitPos]);
    this.mScene.attachChild(fruit);
    return fruit;
}
@Override
protected void onHandleObtainItem(final Sprite pItem) {
    //Before we return the sprite to the caller, we reset it's fields.
    //This method is called internaly by GenericPool<T> class.
    pItem.reset();
}
@Override
protected void onHandleRecycleItem(final Sprite pItem) {
    //When an item is recycled, this method is called. We make it invisible and set it to ignores updates.
    //We DONT detach it from the scene, just make it ignore updates.
    //Again, this method is called internally by GenericPool<T>class.
    pItem.setVisible(false);
    pItem.setIgnoreUpdate(true);
}
// ===========================================================          
// Methods          
// ===========================================================  

// ===========================================================          
// Inner and Anonymous Classes          
// ===========================================================  
}