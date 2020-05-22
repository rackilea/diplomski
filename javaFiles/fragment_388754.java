public class GuidaTv extends Fragment implements View.OnClickListener{

private Button FirstThemButton;
private Button SecondThemButton;
private Button ThirdThemButton;
private SharedPreferences sharePrefences;
private SharedPreferences.Editor editor;

@Override 
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v =inflater.inflate(R.layout.guida_tv,container,false);


    SharePreference(); 

    FirstThemButton =(Button) v.findViewById(R.id.FirstThem);
    SecondThemButton =(Button) v.findViewById(R.id.SecondThem);

    ThirdThemButton =(Button) v.findViewById(R.id.ThirdThem);
    ^^^ This is the culprit! Change the name! 

    InitView();

    return v;
} 


private void SharePreference() { 
    sharePrefences=this.getActivity().getSharedPreferences("config", Context.MODE_WORLD_READABLE
            | Context.MODE_WORLD_WRITEABLE);
    editor=sharePrefences.edit();
    boolean isThem = sharePrefences.getBoolean("isThem", false);
    int Them = sharePrefences.getInt("Them",0);//config不存在时返回0
    if(isThem){
        if(Them==1){
            getActivity().setTheme(R.style.AppTheme2);
        }else if(Them==2){
            getActivity().setTheme(R.style.AppTheme2);
        }else if(Them==3){
            getActivity().setTheme(R.style.AppTheme2);
        } 
    }else{//sharePrefences不存在是使用默认主题 
        getActivity().setTheme(R.style.AppTheme);
    } 
} 

private void InitView() { 
    FirstThemButton.setOnClickListener(this);
    SecondThemButton.setOnClickListener(this);
    ThirdThemButton.setOnClickListener(this);
} 


public void onClick(View v) {
    switch (v.getId()) {
        case R.id.FirstThem:
            editor.putBoolean("isThem", true);
            editor.putInt("Them", 1);
            editor.commit();
            break; 
        case R.id.SecondThem:
            editor.putBoolean("isThem", true);
            editor.putInt("Them",2);
            editor.commit();
            break; 
        case R.id.ThirdThem:
            editor.putBoolean("isThem", true);
            editor.putInt("Them", 3);
            editor.commit();
            break; 
        default: 
            break; 
    } 

}