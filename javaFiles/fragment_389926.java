public class CartActivity extends AppCompatActivity implements IItemClick {

     // change  
    public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    Users_get post = childSnapshot.getValue(Users_get.class);
                    array_data.add(new Users_get(post.getName(),post.getSurname(),post.getPrice(),childSnapshot.getKey()));
                    adapter = new UsersAdapter(array_data, this);
                    mResultList2.setAdapter(adapter);
                }
            }


                override public void onItemClick(String key, int position){
                 // perform your delete operation from firebase here
                 // after delete  
                adapter.notifyItemRemoved(position)
                }

        }