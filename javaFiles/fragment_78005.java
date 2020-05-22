// 1. method Callmeafterstart
MyDragDropListener myDragDropListener = new MyDragDropListener(this);

// 2. class MyDragDropListener
private MojeOkno mojeOkno;
public MyDragDropListener(MojeOkno mojeOkno) {
    this.mojeOkno = mojeOkno;
}

// 3. method drop
// CESTA2 == PATH TO IMG
mojeOkno.InserImgToPanel(cesta2);