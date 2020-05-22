$("#right").animate({blurRadius: 30}, {
        duration: 1000,
        step: function() {
            $(this).css({
                "-webkit-filter": "blur("+this.blurRadius+"px)"
            });
        }
    });