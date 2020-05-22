protected void onTimer(AjaxRequestTarget target) {
    synchronized (this) {
        if(refreshing ){
            if(update != null){
                target.appendJavascript("var obj=document.getElementById(\"output\");var txt=document.createTextNode(\""+update+"\");obj.appendChild(txt)");
                update = null;
            }
        }
    }
}