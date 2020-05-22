public class AnimationSet {
    private final String path, filename;

    public AnimationSet(String path, String filename) {
        this.path = path;
        this.filename = filename;
    }
    public String getPath() {
        return path;
    }
    public String getFilename(){
        return filename;
    }
}

public enum HammerAnimationSet {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4");

    final AnimationSet animationSet;

    HammerAnimationSet(String filename) {
        animationSet=new AnimationSet("hammer/", filename);
    }
    public AnimationSet getAnimationSet() {
        return animationSet;
    }
}

public enum ShopAnimationSet {
    HEART("heart"),
    MANA("mana bottle"),
    LUCK("clover");

    final AnimationSet animationSet;

    private ShopAnimationSet(String filename){
        animationSet=new AnimationSet("shop/", filename);
    }
    public AnimationSet getAnimationSet() {
        return animationSet;
    }
}