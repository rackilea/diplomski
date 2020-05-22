public class ReminderstestExplaination extends Fragment {
boolean isVisible = false;
RecyclerView testexplntion_recycle;
CustomRecyclerview customRecyclerview;
LinearLayout reminderpage_addbutton,extraremlay,del_editlay;

@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.remindertest_explaination,container,false);

    extraremlay = v.findViewById (R.id.extraremlay);

    extraremlay.setOnLongClickListener (new View.OnLongClickListener () {
                                            @Override
                                            public boolean onLongClick(View view) {

                                               if(isVisible) {
                                                isVisible = false;
                                               del_editlay.setVisibility 
                                              (View.INVISIBLE);
                                              }
                                               }
                                               else {
                                             isVisible = true;
                                             del_editlay.setVisibility 
                                              (View.VISIBLE);}

                                                return true;

                                            }
                                        });