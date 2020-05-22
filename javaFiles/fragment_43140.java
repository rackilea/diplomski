FileChannel from = new FileInputStream(sourceFile).getChannel();
FileChanngel to = new FileOutputStream(destFile).getChannel();
to.transferFrom(from, 0, from.size());
//or from.transferTo(0, from.size(), to);
from.close();
to.close();