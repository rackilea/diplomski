window.cz_ario_socialgraphuisvg_Graph = function() {
    // ...
    this.updateSize = function(e) {
    e.element.somethingToUpdateTheSize(); // check d3 documentation
    };

    this.addResizeListener(element, this.updateSize);
}