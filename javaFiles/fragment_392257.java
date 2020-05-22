public class ArrayClass {

ArrayList<Bitmap> undoArray =new ArrayList<Bitmap>();
private int _size;
private Bitmap _mBitmap;

public void incrementArray(Bitmap mBitmap) {
this._mBitmap=mBitmap;
    _size=undoArray.size();
        // undoArray.add(_size, _mBitmap); replace with:
                           undoArray.add(_size, Bitmap.createBitmap(_mBitmap));
        }

public Bitmap undo() {
 // TODO Auto-generated method stub
_  size=undoArray.size();
if (_size>1) {
    undoArray.remove(_size-1);
    _size=undoArray.size();
      _mBitmap = ((Bitmap) undoArray.get(_size-1)).copy(Bitmap.Config.ARGB_8888,true);
        }
return _mBitmap;
}

public Bitmap redo() {
// TODO 
return null;
}
}