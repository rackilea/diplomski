$(document).ready(function(){

new jPlayerPlaylist({
    jPlayer: "#jquery_jplayer_1",
    cssSelectorAncestor: "#jp_container_1"
}, [
    {
        title:"Big Buck Bunny Trailer",
        artist:"Blender Foundation",
        free:true,
        m4v:"http://www.jplayer.org/video/m4v/Big_Buck_Bunny_Trailer.m4v",
        ogv:"http://www.jplayer.org/video/ogv/Big_Buck_Bunny_Trailer.ogv",
        webmv: "http://www.jplayer.org/video/webm/Big_Buck_Bunny_Trailer.webm",
        poster:"http://www.jplayer.org/video/poster/Big_Buck_Bunny_Trailer_480x270.png"
    },
    {
        title:"Finding Nemo Teaser",
        artist:"Pixar",
        m4v: "http://www.jplayer.org/video/m4v/Finding_Nemo_Teaser.m4v",
        ogv: "http://www.jplayer.org/video/ogv/Finding_Nemo_Teaser.ogv",
        webmv: "http://www.jplayer.org/video/webm/Finding_Nemo_Teaser.webm",
        poster: "http://www.jplayer.org/video/poster/Finding_Nemo_Teaser_640x352.png"
    },
    {
        title:"Incredibles Teaser",
        artist:"Pixar",
        m4v: "http://www.jplayer.org/video/m4v/Incredibles_Teaser.m4v",
        ogv: "http://www.jplayer.org/video/ogv/Incredibles_Teaser.ogv",
        webmv: "http://www.jplayer.org/video/webm/Incredibles_Teaser.webm",
        poster: "http://www.jplayer.org/video/poster/Incredibles_Teaser_640x272.png"
    }
], {
    swfPath: "../js",
    supplied: "webmv, ogv, m4v"
});
......

)};