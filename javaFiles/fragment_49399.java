class AdsSliderAdapter(
private val bannerImageList: MutableList<SliderImagesItem>,
private val callback: SliderItemClickListener) :PagerAdapter() {

private var mContext: Context? = null
override fun instantiateItem(container: ViewGroup, position: Int): Any {
    mContext = container.context

    val view = LayoutInflater.from(container.context)
        .inflate(R.layout.item_ad_slider, container, false)

    val adImage: AppCompatImageView = view.ivAd
    mContext?.let {
        GlideApp.with(it).load(bannerImageList[position % bannerImageList.size].imageUrl)
            .into(adImage)
    }
    val viewPager = container as ViewPager
    viewPager.addView(view, 0)

    view.cardView.onClick { callback.onSliderImageClick(bannerImageList[position % bannerImageList.size]) }
    return view
}

override fun isViewFromObject(view: View, `object`: Any): Boolean {
    return view === `object`
}

override fun getCount(): Int {
    return if (bannerImageList.size > 0) {
        Int.MAX_VALUE
    } else {
        0
    }
}

override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    val viewPager = container as ViewPager
    val view = `object` as View
    viewPager.removeView(view)
}

interface SliderItemClickListener {
    fun onSliderImageClick(item: SliderImagesItem)
}