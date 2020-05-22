interface RestApi {
    Observable<ModelA> getModelA();
    Observable<ModelB> getModelB(int modelBId);
}

class ModelA {
    int modelBId;
    Object fieldA;
}

class ModelB {
    Object fieldB;
}

class ModelC {
    Object fieldFromA;
    Object fieldFromB;

    public ModelC(Object fieldFromA, Object fieldFromB) {
        this.fieldFromA = fieldFromA;
        this.fieldFromB = fieldFromB;
    }
}