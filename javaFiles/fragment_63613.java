function test (str) {
    function parseXML( xml ) {
        if( window.ActiveXObject && window.GetObject ) {
            var dom = new ActiveXObject( 'Microsoft.XMLDOM' );
            dom.loadXML( xml );
            return dom;
        }
        if( window.DOMParser )
            return new DOMParser().parseFromString( xml, 'text/xml' );
        throw new Error( 'No XML parser available' );
    }

    str = parseXML(str);
    var supertest = str.getElementsByTagName("tag1")[0].childNodes[0].nodeValue;
    document.getElementById('ici').innerHTML ="value of tag1  :  " + supertest;
}