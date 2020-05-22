String javascript = "javascript:"
                    + "$(document).ready(function() {"
                    + "var btnscan = $('<div/>', {'class': 'profilebuttons','text': 'foobar1'}),btnads = $('<div/>', {'class': 'profilebuttons','text': 'foobar2'}),btnmap = $('<div/>', {'class': 'profilebuttons','text': 'foobar3'});"
                    + "foobar.bind('click', function(){Android.foobar1();});"
                    + "foobar.bind('click', function(){Android.foobar2();});"
                    + "foobar.bind('click', function(){Android.foobar3();});"
                    + "element = document.getElementsByClassName('contentMenu')[0];"
                    + "foobar1.clone(true,true).appendTo(element);"
                    + "foobar2.clone(true,true).appendTo(element);"
                    + "foobar3.clone(true,true).appendTo(element);"
                    + "});";
            view.loadUrl(javascript);