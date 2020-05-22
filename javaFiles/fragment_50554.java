public class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.tv);

            try {
                new ScheduleTimer(textView, getActivity())
                        .main(new String[] {"13.04.2015 13:59", "13.04.2015 14:14", "13.04.2015 14:15"});
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return rootView;
        }
    }