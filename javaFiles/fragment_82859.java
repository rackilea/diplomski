// As a version string, this might be '1.4.2_31'.  
// I.E. it is not a 'number' but a 'string' and therefore must be treated as a string.
var highestVersion = 'undefined';

// not available in IE, but all other known desktop browsers
var mimes = window.navigator.mimeTypes;
// not available in IE, but all other known desktop browsers
var plugins = window.navigator.plugins; 

function isJava() {
    return (
        typeof(navigator.javaEnabled) !== 'undefined' &&
        navigator.javaEnabled());
}

function getVersion() {
    var version = 0;
    if (isJava()) {
        version = 1.1;
    }
    for (var ii=0; ii<mimes.length; ii++) {
        var t = mimes[ii].type;
        if (t.indexOf("java")>0 &&
            t.indexOf("jpi")>0 &&
            t.indexOf("applet")>0
            ) {
            var parts = t.split("=");
            version = parts[parts.length-1];
        }
    }
    if (highestVersion=='undefined') highestVersion = version;
    return version;
}

function isJWS() {
    var ver = highestVersion;
    var className = false;
    if (ver>'1.0') {
        className = undefined;
    }
    if (ver>'1.4.2') {
        className = true;
    }
    return className;
}

function isPlugin2() {
    var ver = highestVersion;
    var className = false;
    if (ver>'1.0') {
        className = undefined;
    }
    if (ver>'1.6.0_10') {
        className = true;
    }
    return className;
}

function getIEVersion() {
    if (testUsingActiveX('1.9.0')) {
        return '1.9.0';
    } else if (testUsingActiveX('1.8.0')) {
        return '1.8.0';
    } else if (testUsingActiveX('1.7.0')) {
        return '1.7.0';
    } else if (testUsingActiveX('1.6.0')) {
        return '1.6.0';
    } else if (testUsingActiveX('1.5.0')) {
        return '1.5.0';
    } else if (testUsingActiveX('1.4.2')) {
        return '1.4.2';
    }
    return false;
}

if (supportsActiveX() && getVersion()=='1.1') {
    highestVersion = getIEVersion();
}

/** This checks directly for the support for ActiveX.  
Internet Explorer 11 completely dropped support for ActiveX. */
function supportsActiveX() {
    return typeof window.ActiveXObject != 'undefined';
}

/*
A fragile way to determine either 'IE' or 'ActiveX support'.
function isIE() {
    // return navigator.appName=='Microsoft Internet Explorer';
    // return navigator.appVersion.indexOf(".NET CLR")>0
    return supportsActiveX();
}
*/

function testUsingActiveX(version) {
    var objectName = 'JavaWebStart.isInstalled.' + version + '.0';

    // we need the typeof check here for this to run on FF/Chrome
    // the check needs to be in place here - cannot even pass ActiveXObject
    // as arg to another function
    if (typeof ActiveXObject == 'undefined' || !ActiveXObject) {
        alert('[testUsingActiveX()] Browser claims to be IE, but no ActiveXObject object?');
        return false;
    }

    try {
        return (new ActiveXObject(objectName) != null);
    } catch (exception) {
        return false;
    }
}

function get3CellRow(cell1, cell2, cell3) {
    var s = "" +
        "<tr>" +
        "<td class='" +
        getClassName(cell1) +
        "'>" +
        cell1 +
        "</td>" +
        getDataStyledCell(cell2) +
        "<td class='" +
        getClassName(cell3) +
        "'>" +
        cell3 +
        "</td>" +
        "</tr>" +
        "";

    return s;
}

function getDataStyledCell(value) {
    var s = "<td class='datum " +
        getClassName(value) +
        "'>" +
        value +
        "</td>";

    return s;
}

function getClassName(val) {
    var className = undefined;

    if (
        (val) ||
        (!val) ||
        (val!=="undefined")
        ) {
        className = val;
    }

    return className;
}

function getBrowserInfo() {
    var s = "";

    var props = [
        'appCodeName','appName','appVersion',
        'userAgent',
        'platform','cookieEnabled'
    ];

    s += "<table border='1'>";
    for (var i=0; i<props.length; i++) {
        s+= "<tr>";
        s+= "<td><b>";
        s+= props[i];
        s+= "</b></td>";
        s+= "<td>";
        s+= navigator[props[i]];
        s+= "</td>";
        s+= "</tr>";
    }
    s += "</table>";

    return s;
}