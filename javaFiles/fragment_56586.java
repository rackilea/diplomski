class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState) {
        super.onCreate(savedInstanceState) 
        setContentView(R.layout.activity_main)

        showNewsFragment()
    }

    fun showNewsFragment() {
        val tag = "NewsListFragment"
        val existingFragmentWithTag = supportFragmentManager.findFragmentByTag(tag)

        if (existingFragmentWithTag == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.newsListFragmentContainer, NewsListFragment(), tag)
                    .commit()
        }
    }

}