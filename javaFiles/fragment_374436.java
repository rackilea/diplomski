/**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

        override fun createFragment(position: Int): Fragment {
            return ScreenSlidePageFragment()
        }

        override fun getItemCount(): Int = NUM_PAGES

        override fun getItem(position: Int): Fragment = SlideFragment()
    }