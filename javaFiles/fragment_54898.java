@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.faq_fragment, container, false);
    ((TextView)view .findViewById(R.id.question_text)).setText(title);
    ((TextView)view .findViewById(R.id.answer_text)).setText(description);

    return view;
}