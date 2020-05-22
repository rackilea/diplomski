public class MainActivity{
    int give_this_int_to_fragment;

    protected void onCreate(...){
        Fragment frag = new FragmentExtender();

    }
}

public int getgive_this_int_to_fragment(){
     return give_this_int_to_fragment;
}
public void getgive_this_int_to_fragment(int var){
     give_this_int_to_fragment = var;
}