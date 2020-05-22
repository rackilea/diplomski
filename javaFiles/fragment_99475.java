public class QuestionFragment extends Fragment {
    private static final String ARG_QUESTION_ID = "question_id";

    public static QuestionFragment newInstance(String questionId) {
        final QuestionFragment fragment = new QuestionFragment();
        final Bundle args = new Bundle();
        args.putString(ARG_QUESTION_ID, questionId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final String questionId = getArguments().getString(questionId);
        final DBAdapter dbAdapter = new DBAdapter(getContext());
        questionsList = dbAdapter.getAllQuestions();
        currentQuestion = questionsList.get(questionId);

        // ...

        return view;
    }
}