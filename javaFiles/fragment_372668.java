function addEvent(element, event, func) {
    if (element.addEventListener) {
        element.addEventListener(event, func, false); // Real browsers.
        return true;
    } else if (element.attachEvent) {
        return element.attachEvent("on" + event, func); // MSIE<=8.
    } else {
        return false; // Really ancient browsers.
    }
}