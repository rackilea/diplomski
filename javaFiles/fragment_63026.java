if(Utils.doesPackageExist(getSherlockActivity(), "com.linkedin.android"))
{           
    Intent shareIntent = new Intent(Intent.ACTION_SEND);
    shareIntent.setClassName("com.linkedin.android",
            "com.linkedin.android.home.UpdateStatusActivity"); 
    shareIntent.setType("text/*");
    shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareText);           
    startActivity(shareIntent);
}
else
{
    Toast.makeText(getSherlockActivity(), "Please install the LinkedIn app to share your result", Toast.LENGTH_LONG).show();
}