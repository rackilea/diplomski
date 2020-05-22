public class ImageDialog extends DialogFragment {

    public static final String ARG_IMAGE_URI = "arg_image_uri";
    public static final String ARG_IMAGE_NAME = "arg_image_name";
    public static final String ARG_IMAGE_ID_CHANNEL = "arg_image_id_channel";

    public ImageDialog(){ // if no argument you can use empty constructor }
    public static ImageDialog getInstance(String uriStr, String imageName, int idChannel){

        ImageDialog imageDialog = new ImageDialog();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_IMAGE_URI, uriStr);
        bundle.putString(ARG_IMAGE_NAME, imageName);
        bundle.putInt(ARG_IMAGE_ID_CHANNEL, idChannel);
        imageDialog.setArguments(bundle);
        return imageDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // inflate first with your own layout dialog 
       return inflater.inflate(R.layout.popup_image_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Look this part
        ImageView imageView = view.findViewById(R.id.popup_image);
        //-------------
        Bundle bundle = getArguments();
        if(bundle != null){
            String name = bundle.getString(ARG_IMAGE_NAME);
            getDialog().setTitle(name);
            String imageUri = bundle.getString(ARG_IMAGE_URI);
            int idChannel = bundle.getInt(ARG_IMAGE_ID_CHANNEL);
            if(idChannel == 0){
                Picasso.with(getContext())
                        .load(new File(imageUri))
                        .into(imageView);

            }else {
                Picasso.with(getContext())
                        .load(imageUri)
                        .into(imageView);
            }

        }

    }
}