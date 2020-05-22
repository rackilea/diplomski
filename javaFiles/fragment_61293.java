<?php

require_once(ROOT.'/lab/lib/xyz_api_int.php');

try {

    //setup the sdk
    $api = YumzingApiInt::_get(
        Config::get('api_int','url'),
        Config::get('api_int','key'),
        Config::get('api_int','secret')
    );

    //connect to the api
    $api->connect();

    //check our token
    echo $api->getToken();

} catch(Exception $e){
    sysError($e->getMessage());
}