import java.util.Arrays;
import java.util.List;

import com.sun.jna.platform.win32.Guid.GUID;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class MAGIMAGEHEADER extends Structure {
    public int width;
    public int height;
    public GUID format;
    public int stride;
    public int offset;
    public BaseTSD.SIZE_T cbsize;

    public List getFieldOrder() {
        return Arrays.asList("width","height","format", "stride","offset","cbsize");
    }

    public static class ByValue extends MAGIMAGEHEADER implements Structure.ByValue {
        public ByValue() {}

        public ByValue(MAGIMAGEHEADER magimageheader) {
            super (magimageheader.getPointer());

            width = magimageheader.width;
            height = magimageheader.height;
            format = magimageheader.format;
            stride = magimageheader.stride;
            offset = magimageheader.offset;
            cbsize = magimageheader.cbsize;
        }

        public ByValue(Pointer memory) {
            super(memory);
        }
    }

    public MAGIMAGEHEADER(Pointer memory) {
        super(memory);
        read();
    }

    public MAGIMAGEHEADER() {
    }
}