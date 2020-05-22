function init() {
//this executes on document ready

//create your elements
    var externDiv = document.createElement('div');
    var internDiv = document.createElement('div');
    externDiv.className = 'row-fluid verticalmenubottom';
    internDiv .className = 'span12 verticalMenuCell appButtonDiv';
    externDiv.appendChild(internDiv);

//find your button and put the new elements in it (check that your jsp don't change the id client-side)
    var btn = document.getElementById('searchButton');
    btn.appendChild(externDiv);
}