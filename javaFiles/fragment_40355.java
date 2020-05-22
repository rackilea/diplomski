if (e.getType() == ServiceException.Type.UNREACHABLE_NETWORK) {  
     info = "error => " + "Lost Connection to Internet";   
}
 else if(e.getType() == ServiceException.Type.CONNECTION_REFUSED) {    
     info = "error => " + "Cant Reach server";
}