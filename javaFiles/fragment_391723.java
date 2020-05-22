@Module
public abstract class ModelModule {
    // Note abstract class and static/abstract methods.

    @BindsOptionalOf
    abstract ModelMqlBased bindOptionalOfModelMqlBased();

    @Provides
    @ModelScope
    static IModel iModel(Optional<ModelMqlBased> modelMqlBased,
            ModelFileBased modelFileBased,
            @Named("configClientType")String clientType) {
        switch (clientType) {
        case "mqlBot": 
            return modelMqlBased.get();
        case "fileBot":
            return modelFileBased;
        default:
            throw new RuntimeException();
        }
    }
}