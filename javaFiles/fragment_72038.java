/**
 * Defines methods to create COM objects
 */
public abstract class ClassFactoryExt {
    private ClassFactoryExt() {} // instanciation is not allowed

    /**
     * Microsoft IMAPIv2 Data Writer
     */
    public static com.ms.imapi2.IDiscFormat2DataExt createMsftDiscFormat2Data() {
        return COM4J.createInstance( com.ms.imapi2.IDiscFormat2DataExt.class, "{2735412A-7F64-5B0F-8F00-5D77AFBE261E}" );
    }
}

/**
 * Data Writer
 */
@IID("{27354153-9F64-5B0F-8F00-5D77AFBE261E}")
public interface IDiscFormat2DataExt extends com.ms.imapi2.IDiscFormat2Data {
    /**
     * The state (usability) of the current media
     */
    @VTID(18)
    //com.ms.imapi2.IMAPI_FORMAT2_DATA_MEDIA_STATE currentMediaStatus();
    int currentMediaStatusExt();
}

/**
 * Defines methods to create COM objects
 */
public abstract class StreamClassFactory {
    private StreamClassFactory() {} // instanciation is not allowed


    /**
     * Boot options
     */
    public static com.ms.imapi2.IBootOptions createBootOptions() {
        return COM4J.createInstance( com.ms.imapi2.IBootOptions.class, "{2C941FCE-975B-59BE-A960-9A2A262853A5}" );
    }

    /**
     * File system image
     */
    public static com.ms.imapi2.IFileSystemImage3 createMsftFileSystemImage() {
        return COM4J.createInstance( com.ms.imapi2.IFileSystemImage3.class, "{2C941FC5-975B-59BE-A960-9A2A262853A5}" );
    }

    /**
     * Microsoft IMAPIv2 Iso Image Manager
     */
    public static com.ms.imapi2.IIsoImageManager createMsftIsoImageManager() {
        return COM4J.createInstance( com.ms.imapi2.IIsoImageManager.class, "{CEEE3B62-8F56-4056-869B-EF16917E3EFC}" );
    }
}