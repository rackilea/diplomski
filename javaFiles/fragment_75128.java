let i=0;
var element = document.querySelectorAll("div>span[jsname='bN97Pc']")[i];
var timer = setInterval(function()
{
    console.log(element);
    element.scrollIntoView();

        i++;
        element = document.querySelectorAll("div>span[jsname='bN97Pc']")[i];
        if(element===undefined)
            clearTimeout(timer);

},500);