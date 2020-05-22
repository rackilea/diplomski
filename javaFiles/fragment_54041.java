public class BottomSheetDialog extends BottomSheetDialogFragment {
        private BottomSheetListener bottomSheetListener;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View  v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
            LinearLayout mRestaurants = v.findViewById(R.id.restaurants);
            mRestaurants.setOnClickListener(v1 -> {
//need to start activity from here
                Intent intent = new Intent(getActivity(), MapActivity.class);
                intent.putExtra("mapData", "Restaurants");
                v1.getContext().startActivity(intent);
            });
            return v;
        }

        }
    }