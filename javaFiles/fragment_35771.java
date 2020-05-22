class ActivityB : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context, n: Int) {
            val intent = Intent(context, ActivityB::class.java)
            intent.putExtra("N", n)
            context.startActivity(intent)
        }

        lateinit var n: Int

        .
        .
        .

        override fun onCreate(savedInstanceState: Bundle?) {
            ...
            n = intent.getIntExtra("N", 0)

            nextButton.setOnClickListener {
                if( n > 0 ) {
                    ActivityB.startActivity(this, n-1)
                } else {
                    // do what you need to do
                }
                activity?.finish()
            }
            ...
        }
    }