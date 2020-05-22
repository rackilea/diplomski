public class GridTextButtonAlignment implements EntryPoint {
  private static final String[] COLORS = new String[] {"161616", "002241", "006874", "82a700", "bbc039", "f3f1cd"};

  interface PlaceProperties extends PropertyAccess<Plant> {
    ValueProvider<Plant, Date> available();

    @Path("name")
    ModelKeyProvider<Plant> key();

    ValueProvider<Plant, String> name();

    ValueProvider<Plant, Integer> difficulty();

    ValueProvider<Plant, Double> progress();

    ValueProvider<Plant, String> color();

    ValueProvider<Plant, String> light();
  }

  private static final PlaceProperties properties = GWT.create(PlaceProperties.class);
  private ListStore<Plant> store;

  public class CellColumnResizer<M, T> implements ColumnWidthChangeHandler {

    private Grid<M> grid;
    private ColumnConfig<M, T> column;
    private ResizeCell<T> cell;

    public CellColumnResizer(Grid<M> grid, ColumnConfig<M, T> column, ResizeCell<T> cell) {
      this.grid = grid;
      this.column = column;
      this.cell = cell;
    }

    @Override
    public void onColumnWidthChange(ColumnWidthChangeEvent event) {
      if (column == event.getColumnConfig()) {
        int w = event.getColumnConfig().getWidth();
        int rows = store.size();

        int col = grid.getColumnModel().indexOf(column);

        cell.setWidth(w - 20);

        ListStore<M> store = grid.getStore();

        for (int i = 0; i < rows; i++) {
          M p = grid.getStore().get(i);

          // option 1 could be better for force fit where all columns are
          // resized
          // would need to run deferred using DelayedTask to ensure only run
          // once
          // grid.getStore().update(p);

          // option 2
          Element parent = grid.getView().getCell(i, col);
          if (parent != null) {
            parent = parent.getFirstChildElement();
            SafeHtmlBuilder sb = new SafeHtmlBuilder();
            cell.render(new Context(i, col, store.getKeyProvider().getKey(p)), column.getValueProvider().getValue(p),
                sb);
            parent.setInnerHTML(sb.toSafeHtml().asString());
          }

        }
      }
    }

  }

  private Widget asWidget() {
    // reduce the padding on text element as we have widgets in the cells
    SafeStyles textStyles = SafeStylesUtils.fromTrustedString("padding: 1px 3px;");

    ColumnConfig<Plant, String> nameColumn = new ColumnConfig<Plant, String>(properties.name(), 100, "Name");
    // IMPORTANT we want the text element (cell parent) to only be as wide as
    // the cell and not fill the cell
    nameColumn.setColumnTextClassName(CommonStyles.get().inlineBlock());
    nameColumn.setColumnTextStyle(textStyles);
    nameColumn.setAlignment(HasHorizontalAlignment.ALIGN_CENTER);

    TextButtonCell button = new TextButtonCell();
    button.setText("Test");
    button.addSelectHandler(new SelectHandler() {

      @Override
      public void onSelect(SelectEvent event) {
        Context c = event.getContext();
        int row = c.getIndex();
        Plant p = store.get(row);
        Info.display("Event", "The " + p.getName() + " was clicked.");
      }
    });
    nameColumn.setCell(button);

    DateCell dateCell = new DateCell();
    dateCell.getDatePicker().addValueChangeHandler(new ValueChangeHandler<Date>() {

      @Override
      public void onValueChange(ValueChangeEvent<Date> event) {
        Info.display("Date Selected",
            "You selected " + DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT).format(event.getValue()));
      }
    });
    dateCell.setPropertyEditor(new DateTimePropertyEditor(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));

    ColumnConfig<Plant, Date> availableColumn = new ColumnConfig<Plant, Date>(properties.available(), 170, "Date");
    availableColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 2px 3px;"));
    availableColumn.setCell(dateCell);

    ListStore<String> lights = new ListStore<String>(new ModelKeyProvider<String>() {
      @Override
      public String getKey(String item) {
        return item;
      }
    });

    lights.add("Mostly Shady");
    lights.add("Mostly Sunny");
    lights.add("Shade");
    lights.add("Sunny");
    lights.add("Sun or Shade");

    ColumnConfig<Plant, String> lightColumn = new ColumnConfig<Plant, String>(properties.light(), 130, "Light");
    lightColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 2px 3px;"));

    ComboBoxCell<String> lightCombo = new ComboBoxCell<String>(lights, new LabelProvider<String>() {
      @Override
      public String getLabel(String item) {
        return item;
      }
    });
    lightCombo.addSelectionHandler(new SelectionHandler<String>() {

      @Override
      public void onSelection(SelectionEvent<String> event) {
        CellSelectionEvent<String> sel = (CellSelectionEvent<String>) event;
        Plant p = store.get(sel.getContext().getIndex());
        Info.display("Lightness Selected", p.getName() + " selected " + event.getSelectedItem());
      }
    });
    lightCombo.setTriggerAction(TriggerAction.ALL);
    lightCombo.setForceSelection(true);

    lightColumn.setCell(lightCombo);
    lightCombo.setWidth(110);


    ColumnConfig<Plant, String> colorColumn = new ColumnConfig<Plant, String>(properties.color(), 140, "Color");
    colorColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 2px 3px;"));

    // This next line only works with any appearance that extends from Base
    ColorPaletteBaseAppearance appearance = GWT.create(ColorPaletteAppearance.class);
    appearance.setColumnCount(6);

    ColorPaletteCell colorPalette = new ColorPaletteCell(appearance, COLORS, COLORS) {
      @Override
      public boolean handlesSelection() {
        return true;
      }
    };
    colorPalette.addSelectionHandler(new SelectionHandler<String>() {

      @Override
      public void onSelection(SelectionEvent<String> event) {
        Info.display("Color Selected", "You selected " + event.getSelectedItem());
      }
    });
    colorColumn.setCell(colorPalette);

    ColumnConfig<Plant, Integer> difficultyColumn = new ColumnConfig<Plant, Integer>(properties.difficulty(), 150,
        "Durability");
    SliderCell slider = new SliderCell() {
      @Override
      public boolean handlesSelection() {
        return true;
      }
    };
    slider.setWidth(140);
    difficultyColumn.setCell(slider);

    final ColumnConfig<Plant, Double> progressColumn = new ColumnConfig<Plant, Double>(properties.progress(), 150,
        "Progress");
    final ProgressBarCell progress = new ProgressBarCell() {
      @Override
      public boolean handlesSelection() {
        return true;
      }
    };
    progress.setProgressText("{0}% Complete");
    progress.setWidth(140);
    progressColumn.setCell(progress);

    List<ColumnConfig<Plant, ?>> l = new ArrayList<ColumnConfig<Plant, ?>>();
    l.add(nameColumn);
    l.add(availableColumn);
    l.add(lightColumn);
    l.add(colorColumn);
    l.add(difficultyColumn);
    l.add(progressColumn);
    ColumnModel<Plant> cm = new ColumnModel<Plant>(l);

    store = new ListStore<Plant>(properties.key());

    List<Plant> plants = new ArrayList<Plant>();
    plants.add(new Plant());

    store.addAll(plants);

    final Grid<Plant> grid = new Grid<Plant>(store, cm);
    grid.setBorders(true);
    grid.getView().setAutoExpandColumn(nameColumn);
    grid.getView().setTrackMouseOver(false);

    grid.getColumnModel().addColumnWidthChangeHandler(new CellColumnResizer<Plant, Double>(grid, progressColumn, progress));

    FramedPanel cp = new FramedPanel();
    cp.setHeadingText("Cell Grid Example");
    cp.setWidget(grid);
    cp.setPixelSize(920, 410);
    cp.addStyleName("margin-10");

    cp.setButtonAlign(BoxLayoutPack.CENTER);
    cp.addButton(new TextButton("Reset", new SelectHandler() {

      @Override
      public void onSelect(SelectEvent event) {
        store.rejectChanges();
      }
    }));

    cp.addButton(new TextButton("Save", new SelectHandler() {

      @Override
      public void onSelect(SelectEvent event) {
        store.commitChanges();
      }
    }));
    return cp;
  }

  /**
 * This is the entry point method.
 */
public void onModuleLoad() {
    Widget con = asWidget();
    Viewport viewport = new Viewport();
    viewport.add(con);
    RootLayoutPanel.get().add(viewport);
}
}