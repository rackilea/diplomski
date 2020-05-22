public interface FragmentInteractionListener {
    void onFragmentInteractionMostPopular(ArrayList<getSetListValueData> arrayList);
}

public interface FilterMethod {
    void FilterList(ArrayList<getSetListValueData> getSetListValueData);
}

public class MainActivity extends AppCompatActivity implements FragmentInteractionListener {

    /** Constructor */
    public MainActivity() {}

    @Override
    void onFragmentInteractionMostPopular(ArrayList<getSetListValueData> arrayList) {

    }
}

public class MostPopularArticle extends Fragment implements FilterMethod {

    private FragmentInteractionListener mListener;

    /** Constructor */
    public MostPopularArticle(Context context, FragmentInteractionListener listener) {
        this.setContext(context);
        this.mListener = listener;
    }

    @Override
    void FilterList(ArrayList<getSetListValueData> getSetListValueData) {

    }
}