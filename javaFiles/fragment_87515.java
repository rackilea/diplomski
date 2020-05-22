final Random rand = new Random();
final TextView tvMessage=(TextView) findViewById(R.id.tvMessage);

// Some prompts to compare against later
final String actionMovie = "Do you wanna see an Action Movie???";
final ArrayList<String> prompts = new ArrayList<>();
prompts.add(actionMovie);

// Your lists
final ArrayList<String> actionMovies = new ArrayList<>();
actionMovies.add("Terminator 2");

// Setup the click event
findViewById(R.id.Yes).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        // Check which prompt is shown
        if (tvMessage.getText().toString().equals(actionMovie)) {

            // Get a random movie
            String movieTitle = actionMovies.get(rand.nextInt(actionMovies.size()));

        } else { } // equals something else
    }