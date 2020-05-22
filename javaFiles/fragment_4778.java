public class Tab1 extends Fragment {

ArrayList<BarEntry> bargroup1;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.tab1, container, false);


    HorizontalBarChart barChart = (HorizontalBarChart)rootView.findViewById(R.id.barchartnew);

    bargroup1 = new ArrayList<>();
    bargroup1.add(new BarEntry(8f, 0));
return rootView;
}

public void test(){

        // Here I want to access bargroup1

    }

}