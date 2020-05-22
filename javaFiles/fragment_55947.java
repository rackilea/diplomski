@Events({ PAGE_CHANGE_EVENT, InternalConstants.GRID_INPLACE_UPDATE + " (internal event)" })
public class CustomeGridPager
{

    ...
    void onAction(int newPage)
    {
       currentPage = newPage;
       this.resources.triggerEvent(PAGE_CHANGE_EVENT, new Object[] { newPage }, null);
    }
}