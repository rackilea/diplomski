RestApi restApi;

Observable<ModelC> observeModelC() {
    return restApi
            .getModelA()
            .flatMap(new Func1<ModelA, Observable<ModelC>>() {
                @Override
                public Observable<ModelC> call(final ModelA modelA) {
                    // Use the modelBId from modelA to get ModelB.
                    return restApi
                            .getModelB(modelA.modelBId)
                            // Combine A & B to create C
                            .map(new Func1<ModelB, ModelC>() {
                                @Override
                                public ModelC call(ModelB modelB) {
                                    return new ModelC(modelA.fieldA, modelB.fieldB);
                                }
                            });
                }
            });
}