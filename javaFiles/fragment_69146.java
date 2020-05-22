View view;
@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.main_fragment, container, false);
    return view;
}