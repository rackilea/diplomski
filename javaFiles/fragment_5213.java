public class MainOverviewController extends vmListener implements Initializable
{
    @FXML
    private ListView<VM> devicesListView; // Points to the listview

    @Override
    public void vmStarted(final VM vm)
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                devicesListView.getItems().add(vm);
            }
        });
    }

    @Override
    public void vmDisconnected(final VM vm)
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                devicesListView.getItems().remove(vm);
            }
        });
    }

    ...
}