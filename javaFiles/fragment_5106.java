public class MainActivity extends AppCompatActivity implements View.OnClickListener, PlaybackPreparer, PlayerControlView.VisibilityListener {

 private PlayerView playerView;
 private ExoPlayer player;
 private PlayerView playerView;
 private Handler mainHandler;
 private DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
 private DataSource.Factory mediaDataSourceFactory;
 protected String userAgent;
 private TrackSelector trackSelector;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);


  playerView = view.findViewById(R.id.player_view);

  mainHandler = new Handler();
  userAgent = Util.getUserAgent(getContext(), "appName");
  mediaDataSourceFactory = buildDataSourceFactory();
  TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter());
  trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
  player = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(getActivity()), trackSelector, new DefaultLoadControl());
  playerView.setPlayer(player);
  playerView.requestFocus();
  playVideoInit();

 }
 private DataSource.Factory buildDataSourceFactory() {
  return buildDataSourceFactory(bandwidthMeter);
 }

 public DataSource.Factory buildDataSourceFactory(TransferListener < ? super DataSource > listener) {
  if (getContext() != null)
   return new DefaultDataSourceFactory(getContext(), listener, buildHttpDataSourceFactory(listener));
  return null;
 }

 public HttpDataSource.Factory buildHttpDataSourceFactory(
  TransferListener < ? super DataSource > listener) {
  return new DefaultHttpDataSourceFactory(userAgent, listener, 60 * 1000,
   60 * 1000, true);
 }

 private MediaSourceEventListener listener = new MediaSourceEventListener() {
  @Override
  public void onLoadStarted(DataSpec dataSpec, int dataType, int trackType,
   Format trackFormat, int trackSelectionReason,
   Object trackSelectionData, long mediaStartTimeMs,
   long mediaEndTimeMs, long elapsedRealtimeMs) {
   Log.e("ExoPlayer", "onLoadStarted");
  }

  @Override
  public void onLoadCompleted(DataSpec dataSpec, int dataType, int trackType,
   Format trackFormat, int trackSelectionReason,
   Object trackSelectionData, long mediaStartTimeMs,
   long mediaEndTimeMs, long elapsedRealtimeMs,
   long loadDurationMs, long bytesLoaded) {
   Log.e("ExoPlayer", "onLoadCompleted Load Duration:  " + loadDurationMs);
  }

  @Override
  public void onLoadCanceled(DataSpec dataSpec, int dataType,
   int trackType, Format trackFormat,
   int trackSelectionReason, Object trackSelectionData,
   long mediaStartTimeMs, long mediaEndTimeMs,
   long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
   Log.e("ExoPlayer", "onLoadCanceled");
  }

  @Override
  public void onLoadError(DataSpec dataSpec, int dataType, int trackType,
   Format trackFormat, int trackSelectionReason,
   Object trackSelectionData, long mediaStartTimeMs,
   long mediaEndTimeMs, long elapsedRealtimeMs,
   long loadDurationMs, long bytesLoaded, IOException error,
   boolean wasCanceled) {
   Log.e("ExoPlayer", "onLoadError");
  }

  @Override
  public void onUpstreamDiscarded(int trackType, long mediaStartTimeMs, long mediaEndTimeMs) {
   Log.e("ExoPlayer", "onUpstreamDiscarded");
  }

  @Override
  public void onDownstreamFormatChanged(int trackType,
   Format trackFormat,
   int trackSelectionReason,
   Object trackSelectionData,
   long mediaTimeMs) {
   Log.e("ExoPlayer", "onDownstreamFormatChanged");
  }
 };
 public void reStartVideoView() {
  if (player != null) {
   player.seekTo(0);
   player.setPlayWhenReady(true);
  } else {
   Log.e("ExoPlayer", "Restart not working....");
  }
 }
 private MediaSource buildMediaSource(Uri uri) {
  int type = Util.inferContentType(uri.getLastPathSegment());
  switch (type) {
   case C.TYPE_DASH:
    return new DashMediaSource.Factory(
      new DefaultDashChunkSource.Factory(mediaDataSourceFactory),
      buildDataSourceFactory())
     .createMediaSource(uri, mainHandler, listener);
   case C.TYPE_SS:
    return new SsMediaSource.Factory(
      new DefaultSsChunkSource.Factory(mediaDataSourceFactory),
      buildDataSourceFactory())
     .createMediaSource(uri, mainHandler, listener);
   case C.TYPE_HLS:
    Log.e("ExoPlayer", "Hls type streaming");
    return new HlsMediaSource.Factory(mediaDataSourceFactory).
    createMediaSource(uri, mainHandler, listener);
   case C.TYPE_OTHER:
    return new ExtractorMediaSource.Factory(mediaDataSourceFactory)
     .createMediaSource(uri, mainHandler, listener);

   default:
    {
     throw new IllegalStateException("Unsupported type: " + type);
    }
  }
 }


 private void playVideoInit() {
  try {
   if (player != null) {
    boolean haveResumePosition = resumeWindow != C.INDEX_UNSET;
    player.prepare(buildMediaSource(Uri.parse(video.getContentUrl())), !haveResumePosition, false);
    player.setPlayWhenReady(true);
    player.seekTo(resumePosition);

   }
  } catch (Exception e) {
   e.printStackTrace();
  }


 }

 private void releasePlayer() {
  if (player != null) {
   player.release();
   player = null;
  }
 }

 @Override
 public void onStart() {
  super.onStart();
  if (Util.SDK_INT > 23) {
   playVideoInit();
  }
 }

 @Override
 public void onResume() {
  super.onResume();
  if ((Util.SDK_INT <= 23 || player == null)) {
   playVideoInit();

  }
 }

 @Override
 public void onPause() {
  super.onPause();
  if (Util.SDK_INT <= 23) {
   releasePlayer();

  }
 }

 @Override
 public void onStop() {
  super.onStop();
  if (Util.SDK_INT > 23) {
   releasePlayer();
  }
 }

 @Override
 public void onClick(View v) {

 }

 @Override
 public void preparePlayback() {
  playVideoInit();
 }

 @Override
 public void onVisibilityChange(int visibility) {

 }
}