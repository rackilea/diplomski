@Override
public boolean onCreateOptionsMenu(Menu menu) {
   this.menuCopy = menu;
   new MenuInflater(<context>).inflate(layout, this.menuCopy);  
   return super.onCreateOptionsMenu(this.menuCopy);
}