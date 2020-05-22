private String litterName;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
        litterName = getArguments().getString("litter_name");
    }
}