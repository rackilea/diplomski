public class AssetFinder {

    private AssetManager assetManager;
    private FileHandleResolver resolver;

    public class AssetDescriptor {
        public String folder;
        public Class<?> assetType;

        public AssetDescriptor(String folder, Class<?> assetType) {
            this.folder = folder;
            this.assetType = assetType;
        }
    }

    private Array<AssetDescriptor> assets = new Array<AssetDescriptor>();

    public AssetFinder(AssetManager assetManager, FileHandleResolver resolver) {
        this.assetManager = assetManager;
        this.resolver = resolver;

        assets.add(new AssetDescriptor("music", Music.class));
        assets.add(new AssetDescriptor("sound", Sound.class)); // You could remove all but this one
        assets.add(new AssetDescriptor("skin", Skin.class));
        assets.add(new AssetDescriptor("texture", Texture.class));
        assets.add(new AssetDescriptor("atlas", TextureAtlas.class));
        assets.add(new AssetDescriptor("font", BitmapFont.class));
        assets.add(new AssetDescriptor("freetype", FreeTypeFontGenerator.class));
        assets.add(new AssetDescriptor("effect", ParticleEffect.class));
        assets.add(new AssetDescriptor("pixmap", Pixmap.class));
        assets.add(new AssetDescriptor("region", PolygonRegion.class));
        assets.add(new AssetDescriptor("model", Model.class));
        assets.add(new AssetDescriptor("level", TiledMap.class));
    }

    public void load() {
        for (AssetDescriptor descriptor : assets) {
            FileHandle folder = resolver.resolve("").child(descriptor.folder);
            if (!folder.exists()) {
                continue;
            }

            for (FileHandle asset : folder.list()) {
                assetManager.load(asset.path(), descriptor.assetType);
            }
        }
    }
}