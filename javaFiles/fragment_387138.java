package test;


public class MoMoTest
    extends MappingObject<MoTest>
{


    public MoMoTest(MoTest moTest) {
        super(moTest);
    }

    @Override
    public MoTest getDataObject() {
        return dataObject;
    }

    @Override
    public String getStandardFormat() {
        return dataObject.toString();
    }

}