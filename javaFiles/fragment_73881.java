public class GridExample implements IsWidget, EntryPoint {
  private static final StockProperties props = GWT.create(StockProperties.class);

  private ContentPanel root;

  @Override
  public Widget asWidget() {
    if (root == null) {
      final NumberFormat number = NumberFormat.getFormat("0.00");

      ColumnConfig<Stock, String> nameCol = new ColumnConfig<Stock, String>(props.name(), 50, SafeHtmlUtils.fromTrustedString("<b>Company</b>"));

      ColumnConfig<Stock, String> symbolCol = new ColumnConfig<Stock, String>(props.symbol(), 100, "Symbol");
      ColumnConfig<Stock, Double> lastCol = new ColumnConfig<Stock, Double>(props.last(), 75, "Last");

      ColumnConfig<Stock, Double> changeCol = new ColumnConfig<Stock, Double>(props.change(), 100, "Change");
      changeCol.setCell(new AbstractCell<Double>() {

        @Override
        public void render(Context context, Double value, SafeHtmlBuilder sb) {
          String style = "style='color: " + (value < 0 ? "red" : "green") + "'";
          String v = number.format(value);
          sb.appendHtmlConstant("<span " + style + " qtitle='Change' qtip='" + v + "'>" + v + "</span>");
        }
      });

      ColumnConfig<Stock, Date> lastTransCol = new ColumnConfig<Stock, Date>(props.lastTrans(), 100, "Last Updated");
      lastTransCol.setCell(new DateCell(DateTimeFormat.getFormat("MM/dd/yyyy")));

      List<ColumnConfig<Stock, ?>> l = new ArrayList<ColumnConfig<Stock, ?>>();
      //Remove name from main set of columns
      //      l.add(nameCol);
      l.add(symbolCol);
      l.add(lastCol);
      l.add(changeCol);
      l.add(lastTransCol);

      //create two column models, one for the locked section
      ColumnModel<Stock> lockedCm = new ColumnModel<Stock>(Collections.<ColumnConfig<Stock, ?>>singletonList(nameCol));
      ColumnModel<Stock> cm = new ColumnModel<Stock>(l);

      ListStore<Stock> store = new ListStore<Stock>(props.key());
      store.addAll(TestData.getStocks());

      root = new ContentPanel();
      root.setHeadingText("Locked Grid Sample");
      root.setPixelSize(600, 300);

      final Resizable resizable = new Resizable(root, Dir.E, Dir.SE, Dir.S);
      root.addExpandHandler(new ExpandHandler() {
        @Override
        public void onExpand(ExpandEvent event) {
          resizable.setEnabled(true);
        }
      });
      root.addCollapseHandler(new CollapseHandler() {
        @Override
        public void onCollapse(CollapseEvent event) {
          resizable.setEnabled(false);
        }
      });

      //locked grid
      final Grid<Stock> lockedGrid = new Grid<Stock>(store, lockedCm) {
        @Override
        protected Size adjustSize(Size size) {
          //this is a tricky part - convince the grid to draw just slightly too wide
          //and so push the scrollbar out of sight
          return new Size(size.getWidth() + XDOM.getScrollBarWidth() - 1, size.getHeight());
        }
      };
      lockedGrid.setView(new GridView<Stock>(){{
        this.scrollOffset=0;
      }});
      //require columns to always fit, preventing scrollbar
      lockedGrid.getView().setForceFit(true);

      //main grid, with horiz scrollbar
      final Grid<Stock> grid = new Grid<Stock>(store, cm);
      //don't want this feature, want to encourage horizontal scrollbars
      //      grid.getView().setAutoExpandColumn(nameCol);
      grid.getView().setStripeRows(true);
      grid.getView().setColumnLines(true);
      grid.setBorders(false);

      grid.setColumnReordering(true);
      grid.setStateful(true);
      grid.setStateId("gridExample");

      //link scrolling
      lockedGrid.addBodyScrollHandler(new BodyScrollHandler() {
        @Override
        public void onBodyScroll(BodyScrollEvent event) {
          grid.getView().getScroller().scrollTo(ScrollDirection.TOP, event.getScrollTop());
        }
      });
      grid.addBodyScrollHandler(new BodyScrollHandler() {
        @Override
        public void onBodyScroll(BodyScrollEvent event) {
          lockedGrid.getView().getScroller().scrollTo(ScrollDirection.TOP, event.getScrollTop());
        }
      });

      HorizontalLayoutContainer gridWrapper = new HorizontalLayoutContainer();
      root.setWidget(gridWrapper);

      //add locked column, only 300px wide (in this example, use layouts to change how this works
      HorizontalLayoutData lockedColumnLayoutData = new HorizontalLayoutData(300, 1.0);

      //this is optional - without this, you get a little offset issue at the very bottom of the non-locked grid
      lockedColumnLayoutData.setMargins(new Margins(0, 0, XDOM.getScrollBarWidth(), 0));

      gridWrapper.add(lockedGrid, lockedColumnLayoutData);

      //add non-locked section, taking up all remaining width
      gridWrapper.add(grid, new HorizontalLayoutData(1.0, 1.0));
    }

    return root;
  }

  @Override
  public void onModuleLoad() {
    RootPanel.get().add(asWidget());
  }
}