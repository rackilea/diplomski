<?php
if(!$facebook->api_client->users_hasAppPermission('create_event')){
        echo'<script type="text/javascript">window.open("http://www.facebook.com/authorize.php?api_key='.FB_API_KEY.'&v=1.0&ext_perm=create_event", "Permission");</script>';
        echo'<meta http-equiv="refresh" content="0; URL=javascript:history.back();">';
        exit;
    }
?>