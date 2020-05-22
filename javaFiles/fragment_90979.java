private List<View> views;

public playerArrayAdapter(Context context, ArrayList<Player> values) {
    super(context, R.layout.timer_view, values);
    views = new ArrayList<View>(values.length);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View playerView;
    if (position < views.size()) {
        playerView = views.get(position);
        if (playerView != null)
            return playerView;
    } else {
        while (views.size() < position)
            views.add(null);
    }
    playerView = new GameTimerView(context);
    views.add(position, playerView);
    players.get(position).setTimerView(playerView);
    return playerView;
}