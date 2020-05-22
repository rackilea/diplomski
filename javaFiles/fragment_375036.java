@Override
public void doPositiveClick( ExportTypeEnum exportType ){
        toast.setText("Preparing Export...");
        toast.show();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                controller.onExport( adapter.getSelected() , exportType);
            }
            }, 3500);

        chooseExportTypeDialogFragment.dismiss();
}