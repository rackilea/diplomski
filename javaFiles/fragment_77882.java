Intent i = new Intent(MainActivity.this, Pdf_Activity.class);
switch (v.getId())
{
    case R.id.btn1:
        i.putExtra("file",1);
            startActivity(i);
        break;
    case R.id.btn2:
        i.putExtra("file",2);
        startActivity(i);
        break;
    case R.id.btn3:
        i.putExtra("file",3);
        startActivity(i);
        break;
    case R.id.btn4:
        i.putExtra("file",4);
        startActivity(i);
        break;
    case R.id.btn5:
        i.putExtra("file",5);
        startActivity(i);
        break;
        default:
            break;
}