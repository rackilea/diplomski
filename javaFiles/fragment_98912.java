private void updateTeamsArray(String[] teams, int from, int to) {
  int index;

  String valueFrom = teams[from];

  if (from < to) {
     for (index = from; index < to; index++) {
        teams[index] = teams[index + 1];
     }
     teams[to] = valueFrom;
  } else {
     for (index = from; index > to; index--) {
        teams[index] = teams[index - 1];
     }
     teams[to] = valueFrom;
  }

  // buildWindow(teams);
  // new P03TopTenTeams(teams);  // delete this!

  // ***** add this *****
  for (int i = 0; i < teams.length; i++) {
     btn[i].setText(teams[i]);
  }
}