public class ActvityBase extends Activity{

    ...

    public void changePagerPosition(int position){
         this.pager.setCurrentItem(position);
    }

}

public MainActivity extends ActivityBase{

    ...

}
public class MyFragment extends Fragment{

    ...

    ((MainActivity)getActivity()).changePagerPosition(position);

}