public class MalfunctionViewPage extends Composite {
    @UiTemplate("MalfunctionViewPage.ui.xml")
    interface MalfunctionViewPageUiBinder extends UiBinder<Widget, MalfunctionViewPage> {
    }

    private static MalfunctionViewPageUiBinder uiBinder = GWT
            .create(MalfunctionViewPageUiBinder.class);

    public MalfunctionViewPage() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}