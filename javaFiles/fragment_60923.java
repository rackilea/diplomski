public class MyAdapter extends BaseExpandableListAdapter {

    private List<Planet> mPlanets;

    private List<Planet> mPlanetsShown;

    public MyAdapter(List<Planet> planets) {
        mPlanets = planets;
        mPlanetsShown = new ArrayList<>(mPlanets);
    }

    @Override
    public int getGroupCount() {
        return mPlanetsShown == null ? 0 : mPlanetsShown.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mPlanetsShown == null ? null : mPlanetsShown.get(groupPosition);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        Planet planet = (Planet) getGroup(groupPosition);

        // TODO create the view
        return null;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mPlanetsShown.get(groupPosition).getChildrenCount();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mPlanetsShown.get(groupPosition).getChild(childPosition);
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {

        String child = mPlanetsShown.get(groupPosition).getChild(childPosition);

        // TODO create the view
        return null;
    }

    public void filter(String planetName, boolean filter) {

        mPlanetsShown.clear();
        for (Planet planet : mPlanets) {

            // if this is the planet we are changing, set the flag
            if (planet.name.equals(planetName)) {
                planet.filtered = filter;
            }

            // whether this is the planet we are changing or not,
            // add this to planets shown if the flag is not set
            if (! planet.filtered) {
                mPlanetsShown.add(planet);
            }
        }

        notifyDataSetChanged();
    }

    public void filter(String planetName, String childName, boolean filter) {

        for (Planet planet : mPlanets) {
            if (planet.name.equals(planetName)) {
                planet.filter(childName, filter);
            }
        }

        notifyDataSetChanged();
    }


    // TODO some code left out here
}