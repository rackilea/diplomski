public class GameObjectLoader extends SynchronousAssetLoader<GameObject, GameObjectLoader.GameObjectParameters> {

    public GameObjectLoader( FileHandleResolver resolver ) {

        super( resolver );
    }

    @Override
    public GameObject load( AssetManager assetManager, String fileName, FileHandle file, GameObjectParameters parameter ) {

        TextureAtlas atlas = assetManager.get( parameter.src, TextureAtlas.class );
        ShaderProgram shaderProgram = assetManager.get( parameter.shaderSrc, ShaderProgram.class );
        JsonValue json = assetManager.get( parameter.jsonSrc, JsonValue.class );
        Calculation calculation = assetManager.get( parameter.id, Calculation.class );

        GameObject gameObject = new GameObject(
            atlas.findRegion( parameter.name ),
            shaderProgram,
            json,
            calculation
        );

        assetManager.unload( parameter.id ); // unload it otherwise it stays in memory

        return gameObject;
    }

    @Override
    public Array<AssetDescriptor> getDependencies( String fileName, FileHandle file, GameObjectParameters parameter ) {

        Array<AssetDescriptor> dependencies = new Array<AssetDescriptor>();

        dependencies.add( new AssetDescriptor<TextureAtlas>( parameter.src, TextureAtlas.class ) );
        dependencies.add( new AssetDescriptor<ShaderProgram>( parameter.shaderSrc, ShaderProgram.class, parameter.shaderParameter ) );
        dependencies.add( new AssetDescriptor<JsonValue>( parameter.jsonSrc, JsonValue.class ) );
        dependencies.add( new AssetDescriptor<Calculation>( parameter.id, Calculation.class ) );

        return dependencies;
    }


    public static class GameObjectParameters extends AssetLoaderParameters<GameObject> {

        // maybe you have a lot of game logic and dont need to load everything from disk make a custom loader for that too
        public String id = "";
        public String src = "";
        public String name = "";
        public String jsonSrc = "";
        public String shaderSrc = "";
        public ShaderProgramLoader.ShaderProgramParameter shaderParameter = null;
    }
}