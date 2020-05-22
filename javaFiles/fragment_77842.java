// This could probably be optimized significantly, but is a real-world
// example of how to use tree edit distance in the browser.

// For cheerio, you'll have to browserify, 
// which requires some fiddling around
// due to cheerio's dynamically generated 
// require's (good grief) that browserify 
// does not see due to the static nature 
// of its code analysis (dynamic off-line
// analysis is hard, but doable).
//
// Ultimately, the goal is to end up with 
// something like this in the browser:
var cheerio = require('./lib/cheerio');

// But you could use jQuery for both sides of this comparison in which case your
// lfn and cfn callback functions become the same for both roots. 

// The easy part, jqgram:
var jq = require("../jqgram").jqgram;

// Make a cheerio DOM:
var html = '<body><div id="a"><div class="c d"><span>Irrelevent text</span></div></div></body>';

var cheeriodom = cheerio.load(html, {
    ignoreWhitespace: false,
    lowerCaseTags: true
});

// For ease, lets assume you have jQuery laoded:
var realdom = $('body');

// The lfn and cfn functions allow you to specify
// how labels and children should be defined:
jq.distance({
    root: cheeriodom,
    lfn: function(node){ 
        // We don't have to lowercase this because we already
        // asked cheerio to do that for us above (lowerCaseTags).
        return node.name; 
    },
    cfn: function(node){ 
        // Cheerio maintains attributes in the attribs array:
        // We're going to put id's and classes in as children 
        // of nodes in our cheerio tree
        var retarr = []; 
        if(!! node.attribs && !! node.attribs.class){
            retarr = retarr.concat(node.attribs.class.split(' '));
        }
        if(!! node.attribs && !! node.attribs.id){
            retarr.push(node.attribs.id);
        }
        retarr = retarr.concat(node.children);
        return  retarr;
    }
},{
    root: realdom,
    lfn: function(node){ 
        return node.nodeName.toLowerCase(); 
    },
    cfn: function(node){ 
        var retarr = [];
        if(!! node.attributes && !! node.attributes.class && !! node.attributes.class.nodeValue){
            retarr = retarr.concat(node.attributes.class.nodeValue.split(' '));
        }
        if(!! node.attributes && !! node.attributes.id && !! node.attributes.id.nodeValue) {
            retarr.push(node.attributes.id.nodeValue);
        }
        for(var i=0; i<node.children.length; ++i){
            retarr.push(node.children[i]);
        }
        return retarr;
    }
},{ p:2, q:3, depth:10 },
function(result) {
    console.log(result.distance);
});