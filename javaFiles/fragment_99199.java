final Random mRandom = new Random(System.currentTimeMillis());

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    final List<ExampleModel> models = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
        final int randomColor = generateRandomPastelColor();
        models.add(new ExampleModel(randomColor, String.valueOf(i)));
    }

    final ExampleAdapter adapter = new ExampleAdapter(getActivity(), models);
    recyclerView.setAdapter(adapter);
}

public int generateRandomPastelColor() {
    final int baseColor = Color.WHITE;

    final int red = (Color.red(baseColor) + mRandom.nextInt(256)) / 2;
    final int green = (Color.green(baseColor) + mRandom.nextInt(256)) / 2;
    final int blue = (Color.blue(baseColor) + mRandom.nextInt(256)) / 2;

    return Color.rgb(red, green, blue);
}