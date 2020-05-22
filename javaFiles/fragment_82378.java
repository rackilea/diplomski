private Fragment       mFragment;
private final String   mTag;
private final Class<T> mClass;

public TabListener(String pTag, Class<T> pClass) {
    mTag = pTag;
    mClass = pClass;
}

@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {
    if ( mFragment == null ) {
        try {
            mFragment = (Fragment)mClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ft.add(R.id.fragment_container,mFragment,mTag);
    } else {
        ft.attach(mFragment);
    }   
}

@Override
public void onTabUnselected(Tab tab, FragmentTransaction ft) {

    if ( mFragment != null ) {
        ft.detach(mFragment);
    }
}

   public void onTabReselected(Tab tab, FragmentTransaction ft) {
    //Nothing   
   }