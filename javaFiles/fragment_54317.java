private void loadMenu() {
FirebaseRecyclerAdapter<Category,MenuViewHolder>
                          adapter = new                                     
FirebaseRecyclerAdapter <Category, MenuViewHolder>    

 (Category.class,R.layout.item_menu, 
 MenuViewHolder.class,category) {
        @Override
        protected void      


 populateViewHolder(MenuViewHolder   viewHolder,     

 Category model, int position) {


  viewHolder.txtMenuname.setText(model.getName());
  If (model.getimage() != null){          

 Picasso.with(getapplicationcontext()). 
 load (model.getImage())
                    .into(viewHolder.imageView);}
  else {//Toast here}
            final Category clickItem = model;
            viewHolder.setItemClickListener(new      

ItemClickListener() {
                @Override
                public void OnClick(View view, int position,     

boolean isLongClick) {


Toast.makeText(navi.this,""+clickItem.getName(), 
Toast.LEN
 GTH_SHORT).show();
            }

                @Override
                public void onItemClick(AdapterView<?> parent,       

 View view, int position, long id) {

                }
            });

        }
     };
      recycle_menu.setAdapter(adapter);
   }