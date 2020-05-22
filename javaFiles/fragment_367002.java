@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ...

        fragment_cards = inflater.inflate(R.layout.fragment_cards, container, false);
        viewPager = fragment_cards.findViewById(R.id.viewPager);
        ...
        return fragment_cards; 
    }