override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val addButton = findViewById<Button>(R.id.addButton)
    val editText1 = findViewById<EditText>(R.id.editText1)
    val editText2 = findViewById<EditText>(R.id.editText2)
    val resultTextView = findViewById<TextView>(R.id.resultTextView)

    addButton.setOnClickListener {
        val result = editText1.text.toString() + editText2.text.toString()
        resultTextView.text = result
    }
}