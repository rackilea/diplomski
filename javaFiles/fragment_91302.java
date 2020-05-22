public static void launchFragment(Fragment fragment, Context context){
    FragmentManager fragmentManager = ((AppCompatActivity)context).getFragmentManager();
    FragmentTransaction ft = fragmentManager.beginTransaction();
    ft.addToBackStack(null);

    ft.replace(R.id.main_content, fragment);
    ft.commit();
}