import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var employees: List<Employee>? = null
        try {
            val parser = XmlPullParserHandler()
            val istream = assets.open("employees.xml")
            employees = parser.parse(istream)

            val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, employees)
            listView.adapter = adapter  // here, the listView variable name refers to the id given in the xml file

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}