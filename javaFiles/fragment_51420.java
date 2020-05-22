@Override
public void onComputeInsets(InputMethodService.Insets outInsets) {
    super.onComputeInsets(outInsets);
    if (!isFullscreenMode()) {
        outInsets.contentTopInsets = outInsets.visibleTopInsets;
    }
}