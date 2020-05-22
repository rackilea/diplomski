String jarName;
switch(System.getProperty('os.name').toLowerCase().split()[0]) {
  case 'windows':
    jarName = 'swt_win_32.jar' 
    break
  case 'linux':
    jarName = 'swt_linux_x86.jar' 
    break
  default:
    throw new Exception('Unknown OS')
}

dependencies {
  runtime fileTree(dir: 'swt', include: jarName)
}