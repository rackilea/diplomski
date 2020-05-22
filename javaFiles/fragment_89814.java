@Override
public Object instantiateItem(ViewGroup container, int position){

    Fragment createdFragment = (Fragment) super.instantiateItem(container, position);

    switch (position){
        case 0:
            xyzWeakReference=null;
            xyzFragmentWeakReference=new WeakReference<>((xyz)createdFragment);
            break;

        case 1:
            xyz1WeakReference=null;
            xyz1WeakReference=new WeakReference<>((xyz1WeakReference)createdFragment);
            break;

    }

    return createdFragment;
};