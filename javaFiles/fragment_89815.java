public Fragment getFragmentAtGivenPosition(int i){
    switch (i){
        case 0:
            if(xyzFragmentWeakReference == null){
                return null;
            }
            return xyzFragmentWeakReference.get();
        case 1:
            if(xyz1FragmentWeakReference == null){
                return null;
            }
            return xyz1FragmentWeakReference.get();

    }
}