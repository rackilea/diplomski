window.onload = function ()
{
    var output = document.getElementById('foo');

    setInterval(function ()
    {
        output.innerHTML = Math.floor(Math.random() * 10);
    }, 1000);
};