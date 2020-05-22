function trimtext(){  
        $(document).ready(function () {                  
            $(".ui-dt-c").each(function () {                            
                if ($.trim($(this).text()).length > iLimitTextSize) {
                    $(this).attr("title",$.trim($(this).text()));
                    $(this).text($.trim($(this).text()).substring(0, iLimitTextSize));
                    $(this).html($(this).html() + '...');
                }
            });
        });
    }