override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                    val menufragment: Fragment = YourFragment()
                    val args = Bundle()
                    args.putString("str1", text) //text and text1 are strings
                    args.putString("str2", text1)
                menufragment.arguments = args
                    val fr = fragmentManager?.beginTransaction()
                    fr?.replace(R.id.content_frame, menufragment)
                    fr?.addToBackStack(null)
                    fr?.commit()
}