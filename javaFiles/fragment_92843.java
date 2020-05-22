function focusOnScanner()
{
    if($("#scannerTxt").length == 1)
    {
        document.getElementById('scannerTxt').focus();
        var scannedData = $("#scannerTxt").val();
        if(scannedData.length > 0)
        {
            $("#scannerTxt").val('');
            //Here do your work
        }
     }
     setTimeout(focusOnScanner, 5000);
}
setTimeout(focusOnScanner, 5000);