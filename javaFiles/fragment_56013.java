<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head>
        <title>Demo: jQuery Slide &amp; Fade Content</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
        <script type="text/javascript" src="slide-fade-content.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('.more').live('click',function(){
                    var href = $(this).attr('href');
                    if ($('#ajax').is(':visible')) {
                        $('#ajax').css('display','block').animate({height:'1px'}).empty();
                    }
                    $('#ajax').css('display','block').animate({height:'200px'},function(){
                        $('#ajax').html('<img class="loader" src="loader.gif" alt="">');
                        $('#ajax').load('slide-fade-content.html #'+href,function(){
                            $('#ajax').hide().fadeIn().highlightFade({color:'rgb(253,253,175)'});
                        });
                    });
                    return true;
                });

             $('.more').first().click();
            });
        </script>
    </head>
    <body>
        <div id="wrap">
            <div id="demo">
                <table width="900" border="1"><tr><td width="150" valign="top"><ul>
                    <li><a class="more" href="#first-item">First Item</a></li>
                    <li><a class="more" href="#second-item">Second Item</a></li>
                    <li><a class="more" href="#third-item">Third Item</a></li>
                </ul></td>
                <td width="750"><div id="ajax"></div></td></tr></table>
            </div>
        </div>
    </body>
</html>