<?php
    $url = 'http://highcharts-server/exporting-server/php/php-phantomjs/index.php';
    $filename = 'test.png';

    $hc_options = <<<EOF
    EOF;
    $hc_svg = <<<EOF
    EOF; 
    $hc_type = 'image/png';
    $hc_width = '600';
    $hc_scale = '';
    $hc_product = 'highcharts';
    $hc_callback = "function(){alert('hallo from highcharts')}";

    $post_data = array('options'=>$hc_options,'svg'=>$hc_svg,'type'=>$hc_type,'width'=>$hc_width,'scale'=>$hc_scale,'product'=>$hc_product,'callback'=>$hc_callback);
    $curl_data = http_build_query($post_data);

    $options[CURLOPT_RETURNTRANSFER] = true; // return web page
    $options[CURLOPT_HEADER] = false; // don't return headers 
    $options[CURLOPT_FOLLOWLOCATION] = true; // follow redirects
    $options[CURLOPT_ENCODING] = ""; // handle all encodings
    $options[CURLOPT_USERAGENT] = "ap testing highcharts"; // who am i
    $options[CURLOPT_AUTOREFERER] = true; // set referer on redirect
    $options[CURLOPT_CONNECTTIMEOUT] = 10; // timeout on connect
    $options[CURLOPT_TIMEOUT] = 20; // timeout on response
    $options[CURLOPT_MAXREDIRS] = 10; // stop after 10 redirects

    $options[CURLOPT_POST] = 1; // i am sending post data
    $options[CURLOPT_POSTFIELDS] = $curl_data; // the post data in get format (e.g. name=Bob&age=12

    $options[CURLOPT_SSL_VERIFYHOST] = 0;
    $options[CURLOPT_SSL_VERIFYPEER] = false; 

    #$options[CURLOPT_VERBOSE] = 1; // outputs the web page

    $ch      = curl_init($url); 
    curl_setopt_array($ch,$options);

    $content = curl_exec($ch); 
    $err     = curl_errno($ch);
    $errmsg  = curl_error($ch) ;
    $header  = curl_getinfo($ch);
    curl_close($ch);

    file_put_contents($filename, $content);
    ?>