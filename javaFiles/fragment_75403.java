public class ExportActionListener implements ActionListener{

    private VisualizationViewer<V, E> wvv;
    public ExportActionListener(VisualizationViewer<V, E> vv) {
        this.wvv = vv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExportDialog export = new ExportDialog();
        export.showExportDialog(wvv, "Export view as ...", wvv, "export");
    }
}