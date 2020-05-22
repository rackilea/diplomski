public class BottomSheetFrag extends 
          BottomSheetDialogFragment {
          public OnclickDataLisnter clickListner;
          public static BottomSheetFrag newInstance() {
            return new BottomSheetFrag();
          }
          public void setClickListner(OnclickDataLisnter clickListner){//add this
            this.clickListner = clickListner; // add this

            }
         public View onCreateView(LayoutInflater inflater,
                     @Nullable ViewGroup container,
                     @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.activity_appointment, container, false);

      Bundle bundle = getArguments();
    userID = bundle.getString("UserId");


      ImageView imageViewClose = (ImageView) view.findViewById(R.id.imageClose);
       final Fragment f = getActivity().getFragmentManager().findFragmentById(R.id.Linear_layout);


   imageViewClose.setOnClickListener(new View.OnClickListener() 
   {
    @Override
    public void onClick(View v) {

        dismiss();

        }
   });

    button9AM1 = (Button) view.findViewById(R.id.button9AM1);

        /* when i click the button9AM1 i want to send the data as as 9AM to main activity */
        clickListner.onClick(data); //add this

  }}