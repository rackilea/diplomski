Assume that the Twitter object is mytTwitter
*get the user from the twitter object

User user = mytTwitter.showUser(mytTwitter.getid());

*get the profile image URL

URL url = user.getProfileImageURL();


*create Image icon

ImageIcon img = new ImageIcon(url);

*set the JLabel icon to be the ImageIcon

Jlabel1.setIcon(img);