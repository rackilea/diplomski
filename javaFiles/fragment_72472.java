<?php
/**
 * sqlsrv authentication backend
 *
 * @license    GPL 2 (http://www.gnu.org/licenses/gpl.html)
 * @author     Yuriy Shikhanovich <yuriys@gmail.com>
 */

class auth_sqlsrv extends auth_basic {
    /**
     * Constructor
     *
     * Carry out sanity checks to ensure the object is
     * able to operate. Set capabilities.
     *
     * @author  Yuriy Shikhanovich <yuriys@gmail.com>
     */
    function __construct() {

            global $config_cascade;
            global $connection;

      $this->cando['external']       = true;
    }

    function trustExternal()
    {
        //$msgTxt = $_SESSION[DOKU_COOKIE]['auth']['info']['user']."x";
        //msg($msgTxt);
        //return true;

        global $USERINFO;
            global $conf;
            global $connection;


        //already logged in, no need to hit server
        if (!empty($_SESSION[DOKU_COOKIE]['auth']['info'])) 
        {
                $USERINFO['name'] = $_SESSION[DOKU_COOKIE]['auth']['info']['user'];
                $USERINFO['mail'] = $_SESSION[DOKU_COOKIE]['auth']['info']['mail'];
                $USERINFO['grps'] = $_SESSION[DOKU_COOKIE]['auth']['info']['grps'];
                $_SERVER['REMOTE_USER'] = $_SESSION[DOKU_COOKIE]['auth']['user'];
                return true;
            }

        //check server based on token

        try
        {
            $token = $_GET["token"];
            if($token==null)
                $token = $_POST["token"];
            if($token==null)    
                $token = $_SESSION[DOKU_COOKIE]['auth']['token'];

            if($token==null)    
            {
                msg("Could not authenticate. Please contact your admin.");
                return false;
            }

            //config //NOTE: replace with the appropriate values
                $myServer = "1.1.1.1,1433";
                $myUser = "sqlaccount";
                $myPass = "sqlpassword";
                $myDB = "dbName";
                //end config

                //get connection
                $connectionInfo = array('UID' => $myUser, 'PWD' => $myPass, "Database"=>$myDB);
                $link = sqlsrv_connect($myServer, $connectionInfo);

                //check connection
                if($link === FALSE) 
                {
                        msg("Could not get connection, contact your admin.");
                    return false;
                }

                //run token against proc
                //NOTE: this needs to be implemented on your server, returns :
                //"user" - Name of the user //this does not have to be setup in the wiki
                //"email" - user's email //this does not have to be setup in the wiki
                //"groups" - Which groups //this *does* have to be setup in the wiki to be used with ACL
                $sql = "exec WikiLogin '".$token."'"; 
                $stmt = sqlsrv_query( $link, $sql);

                //check statement
                if( $stmt === false) 
                {
                        msg("Could not get connection statement, contact your admin.");
                    return false;
                }

                //if returned results, set user and groups
                while( $row = sqlsrv_fetch_array( $stmt, SQLSRV_FETCH_ASSOC) ) 
                {
                    // set the globals if authed
                    $USERINFO['name'] = $row['user'];
                    $USERINFO['mail'] = $row['email'];
                    $USERINFO['grps'] = split(" ",$row['groups']);

                    //msg(implode($row," "));
                    //msg(implode($USERINFO," "));

                    $_SERVER['REMOTE_USER'] = $row['user'];

                    //uncomment after testing
                    $_SESSION[DOKU_COOKIE]['auth']['user'] = $row['user'];
                    $_SESSION[DOKU_COOKIE]['auth']['mail'] = $row['email'];
                    $_SESSION[DOKU_COOKIE]['auth']['token'] = $token;
                    $_SESSION[DOKU_COOKIE]['auth']['info'] = $USERINFO;

                    sqlsrv_free_stmt( $stmt);
                    sqlsrv_close($link);
                    return true;
                }

                return false;


                if(isset($link))
                    sqlsrv_close($link);
                else
                    msg("Could not get connection, contact your admin.");

                if(isset($stmt))
                    sqlsrv_free_stmt($stmt);
                else
                    msg("Could not get connection, contact your admin.");
            }
            catch (Exception $e)
      {
        if(isset($link))
                    sqlsrv_close($link);
                else
                    msg("Could not get connection, contact your admin.");

                if(isset($stmt))
                    sqlsrv_free_stmt($stmt);
                else
                    msg("Could not get connection, contact your admin.");
      }
        }
}