public class MyPagerAdapter extends PagerAdapter
    {
        public Context  context;

        MyPagerAdapter(Context context)
        {
            this.context = context;
        }

        public int getCount()
        {
            return 5;
        }

    }