function invokeLogic(){
document.yourFormName.action='somePath.do?method=someMethodWithLogic';
document.yourFormName.submit();
}

<input type="text" onblur="invokeLogic()"/>