View sheetView = ... ;    
BottomSheetBehavior behavior = BottomSheetBehavior.from(sheetView);
int initState = BottomSheetBehavior.STATE_EXPANDED;

sheetView.post(new Runnable() {
    @Override
    public void run() {
        behavior.setState(initState);
    }
});