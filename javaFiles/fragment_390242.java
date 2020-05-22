<?php

require_once '../include/File_Streamer.php';
require_once '../include/DbHandler.php';


if (!isset($_SERVER['HTTP_X_FILE_NAME']) || !isset($_SERVER['HTTP_VID_ID']) || !isset($_SERVER['HTTP_VID_INDEX'])) {
    throw new Exception("Invalid Headers!");
} else {

    $im_path = $_SERVER['HTTP_X_FILE_NAME'];
    $id = $_SERVER['HTTP_VID_ID'];
    $index = $_SERVER['HTTP_VID_INDEX'];
    $db = new DbHandler();
    $response = array();

    if($db->updateVideo($id, $im_path)) {
        $im_path2 = explode("_",$im_path);
        $im_path2[0] .= 's';
        $im_path2[2] = $im_path;
        $im_path3 = implode("/",$im_path2);
        $filepath = '../images/'.$im_path3;
        $dirpath = str_replace($im_path,"",$filepath);
        $ft = new File_Streamer();
        $ft->setDestination(__DIR__ . '/' . $dirpath);
        if ($ft->receive()) {
            echo "ERROR - FALSE\n";
            echo "MESSAGE - UPLOADED VIDEO WITH SUCCES\n";
            echo "INDEX - " . $index;
        } else {
            echo "ERROR - TRUE\n";
            echo "MESSAGE - FAILED TO SAVE VIDEO FILE";
        }
    } else {
        echo "ERROR - TRUE\n";
        echo "MESSAGE - FAILED TO ADD TO DATABASE";
    }
}