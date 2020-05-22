View mView;
Button mAcceptReqBtn;
public RequestViewHolder(View itemView)
{

    super(itemView);
    mView=itemView;
    mAcceptReqBtn = (Button) itemView.findViewById(R.id.request_accept_btn);

}