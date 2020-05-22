PKGS=$(find "$RPM_DIR" -iname "*.rpm" -type f -exec rpm -qp --qf "%{NAME} " {} \; | sed 's/ $//')
RPMS=$(find "$RPM_DIR" -iname "*.rpm" -type f | awk '{print}' ORS=' ')

if [ "$INTERACTIVE" != true ]; then
  sudo yum -y --disablerepo=* remove $PKGS
  sudo yum -y --nogpgcheck localinstall $RPMS
else
  sudo yum --disablerepo=* remove $PKGS
  sudo yum --nogpgcheck localinstall $RPMS
fi