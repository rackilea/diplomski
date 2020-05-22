if(user.getRcoCode() != null){
    birtypelist =birdao.getAllBirFormNumber();
}else{
    //no-op
}

//expose 'birtypelist' as an attribute
request.setAttribute("birtypelist", birtypelist);