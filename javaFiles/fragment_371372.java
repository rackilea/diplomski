function addFunctionToAllButtons()
{
    var buttons = document.*YourForm*.getElementsByTagName("button"); 
    for(i=0; i<buttons.length; i++)
    {
        if(buttons[i].id =='yourButtonId')
        {
        attachEvent(buttons[i],'click',*yourFunction*,false);
        }
    }

}


function attachEvent(obj,evt,fnc,useCapture)
{
    if (!useCapture) useCapture=false;
    if (obj.addEventListener)
    {
        obj.addEventListener(evt,fnc,useCapture);
        return true;
    }
    else if (obj.attachEvent) 
        return obj.attachEvent("on"+evt,fnc);
    else
    {
        MyAttachEvent(obj,evt,fnc);
        obj['on'+evt]=function(){ MyFireEvent(obj,evt) };
    }
}