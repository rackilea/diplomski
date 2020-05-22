jQuery(document).ready(function($) {
    $('div.accordion > ul').makeacolumnlists({
        cols: 3,
        colWidth: '33%',
        equalHeight: false,
        startN: 1
    });
    $('div.accordion > div > ul').accordion({
        autoHeight: false,
        header:'> li > h4',
        collapsible: true,
        active: false
    });
    $('ul.col2').makeacolumnlists({
        cols: 2,
        colWidth: 0,
        equalHeight: false,
        startN: 1
    });
    $('ul.col3').makeacolumnlists({
        cols: 3,
        colWidth: 0,
        equalHeight: false,
        startN: 1
    });
});