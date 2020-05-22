if(info.groupFormed){
    if(info.isGroupOwner){
        instructIntent = new Intent(getActivity(), LeaderActivity.class);
    }
    else{
        instructIntent = new Intent(getActivity(), MusicianActivity.class);
    }
    //all of your putExtra and startIntent calls here
}