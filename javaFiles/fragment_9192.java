public interface CodeLineRead extends StdCallCallback {
    int invoke(S_IMAGE_INFO_LS800 info);
}
public interface ImageFrontReady extends StdCallCallback {
    int invoke(S_IMAGE_INFO_LS800 info);
}
public interface ImageBackReady extends StdCallCallback {
    int invoke(S_IMAGE_INFO_LS800 info);
}

int LS800AutoDocHandle(CodeLineRead f1, ImageFrontReady f2, ImageBackReady f3);