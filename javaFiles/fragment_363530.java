@Override 
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.YourLayout);

FragmentManager fragmentManager=getFragmentManager();
FragmentTransaction transaction=fragmentManager.beginTransaction();
code_Fragment code=new code_Fragment(); //Create Object Of your Fragment
transaction.replace(R.id.FragmentLoginRegistration,code);
transaction.commit();
}