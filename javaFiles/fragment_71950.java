// Image:
img_view = (ImageView) item_view_second.findViewById(R.id.item_image);
if(img_detected[position] == 1) {
img_view.setVisibility(View.VISIBLE);
img_loader = new image_loader(second_activity.this);    
img_loader.DisplayImage(current_post.get_image(), img_view);        
} else {
img_view.setVisibility(View.GONE);
}