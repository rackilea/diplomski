$mgr = org.apache.commons.vfs2.VFS.getManager();

function vfs_open($filename, $mode) {
   if ($mode=="r") {
      return $mgr->resolveFile($filename)->content->getInputStream();
   }
   else if ($mode=="w") {
      return $mgr->resolveFile($filename)->content->getOutputStream();
   }
  // todo - handle other mode combinations
}
function vfs_read($resource, $length) {
   $buf = str_repeat(" ", 1024);
   $lenRead = $resource->read($buf, 0, 1024);
   if ($lenRead<0) return "";
   return substr($buf, 0, $lenRead);
}