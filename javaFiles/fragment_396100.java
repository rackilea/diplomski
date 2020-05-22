@Plugin(name = "NoMarkerFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE, printObject = true)
public class NoMarkerFilter extends AbstractFilter {


  private NoMarkerFilter(final Result onMatch, final Result onMismatch) {
    super(onMatch, onMismatch);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object... params) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final Object msg,
                       final Throwable t) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final Message msg,
                       final Throwable t) {
    return filter(marker);
  }

  @Override
  public Result filter(final LogEvent event) {
    return filter(event.getMarker());
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0, final Object p1) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0, final Object p1, final Object p2) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0, final Object p1, final Object p2, final Object p3) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0, final Object p1, final Object p2, final Object p3,
                       final Object p4) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0, final Object p1, final Object p2, final Object p3,
                       final Object p4, final Object p5) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0, final Object p1, final Object p2, final Object p3,
                       final Object p4, final Object p5, final Object p6) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0, final Object p1, final Object p2, final Object p3,
                       final Object p4, final Object p5, final Object p6,
                       final Object p7) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0, final Object p1, final Object p2, final Object p3,
                       final Object p4, final Object p5, final Object p6,
                       final Object p7, final Object p8) {
    return filter(marker);
  }

  @Override
  public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                       final Object p0, final Object p1, final Object p2, final Object p3,
                       final Object p4, final Object p5, final Object p6,
                       final Object p7, final Object p8, final Object p9) {
    return filter(marker);
  }

  private Result filter(final Marker marker) {
    return null == marker ? onMatch : onMismatch;
  }

  /**
   * Create the NoMarkerFilter.
   *
   * @param match    The action to take if a match occurs.
   * @param mismatch The action to take if no match occurs.
   * @return A NoMarkerFilter.
   */
  @PluginFactory
  public static NoMarkerFilter createFilter(
      @PluginAttribute("onMatch") final Result match,
      @PluginAttribute("onMismatch") final Result mismatch) {
    return new NoMarkerFilter(match, mismatch);
  }
}