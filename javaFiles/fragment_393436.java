public class PDFPagerAdapter extends PagerAdapter {
  /**
   * context for the view
   */
  private Context context;

  /**
   * pdf file to show
   */
  private File file;

  /**
   * file descriptor of the PDF
   */
  private ParcelFileDescriptor mFileDescriptor;

  /**
   * this scale sets the size of the {@link PdfRenderer.Page} in the {@link
   * PDFRegionDecoder}.
   * Since it rescales the picture, it also sets the possible zoom level.
   */
  private float scale;

  /**
   * this renderer is only used to count the pages
   */
  private PdfRenderer renderer;

  /**
   * @param file the pdf file
   */
  public PDFPagerAdapter(Context context, File file) {
    super();
    this.context = context;
    this.file = file;
    this.scale = 8;
    try {
      mFileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
      renderer = new PdfRenderer(mFileDescriptor);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Instantiate an item. Therefor a {@link SubsamplingScaleImageView} with special decoders is
   * initialized and rendered.
   *
   * @param container isn't used here
   * @param position the current pdf page position
   */
  public Object instantiateItem(ViewGroup container, int position) {

    SubsamplingScaleImageView imageView = new SubsamplingScaleImageView(context);

    // the smaller this number, the smaller the chance to get an "outOfMemoryException"
    // still, values lower than 100 really do affect the quality of the pdf picture
    int minimumTileDpi = 120;
    imageView.setMinimumTileDpi(minimumTileDpi);

    //sets the PDFDecoder for the imageView
    imageView.setBitmapDecoderFactory(() -> new PDFDecoder(position, file, scale));

    //sets the PDFRegionDecoder for the imageView
    imageView.setRegionDecoderFactory(() -> new PDFRegionDecoder(position, file, scale));

    ImageSource source = ImageSource.uri(file.getAbsolutePath());

    imageView.setImage(source);

    container.addView(imageView);
    return imageView;
  }

  /**
   * gets the pdf site count
   *
   * @return pdf site count
   */
  public int getCount() {
    return renderer.getPageCount();
  }

  @Override public void destroyItem(ViewGroup container, int position, Object view) {
    container.removeView((View) view);
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }
}