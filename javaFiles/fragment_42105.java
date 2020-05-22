class CalculationLoader extends SynchronousAssetLoader<Calculation, AssetLoaderParameters<Calculation>> {

    public CalculationLoader( FileHandleResolver resolver ) {

        super( resolver );
    }

    @Override
    public Calculation load( AssetManager assetManager, String fileName, FileHandle file, AssetLoaderParameters<Calculation> parameter ) {

        // this is the heavy processing
        // the AssetManager dictates how many of these per cycle will be calculated
        return new Calculation();
    }

    @Override
    public Array<AssetDescriptor> getDependencies( String fileName, FileHandle file, AssetLoaderParameters<Calculation> parameter ) {

        return null;
    }

    public static class CalculationParameters extends AssetLoaderParameters<Calculation> {


    }
}