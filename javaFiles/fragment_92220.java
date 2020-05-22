class JavaClass
{
    private long native_ptr = 0;
    private native long createNativeInstance( params );
    private native String nativeMethod( params );
    private native void destroyNativeInstance( long p_native_ptr );
    public JavaClass( params )
    {
        this.native_ptr = createNativeInstance( params );
    }
    public String javaMethod( params )
    {
        nativeMethod( this.native_ptr, params );
    }
    public void finalize()
    {
        destroyNativeInstance( this.native_ptr );
    }
}