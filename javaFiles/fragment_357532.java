private FirstTabView firstTabView;
@Override
public void onCreate(Bundle bundle) {
    ........
    if(firstTabView != null) {
        firstTabView.PostStuff("Hello World");
    }
}

public void setFirstTabView(FirstTabView firstTabView){
    this.firstTabView = firstTabView
}