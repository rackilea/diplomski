@Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId()==R.id.paste) {
      boolean handled=false;

      ClipData clip=
        getSystemService(ClipboardManager.class)
          .getPrimaryClip();

      if (clip!=null) {
        ClipData.Item clipItem=clip.getItemAt(0);

        if (clipItem!=null) {
          imageUri=clipItem.getUri();

          if (imageUri!=null) {
            showThumbnail();
            handled=true;
          }
        }
      }

      if (!handled) {
        Toast
          .makeText(this, "Could not paste an image!", Toast.LENGTH_LONG)
          .show();
      }

      return(handled);
    }

    return(super.onOptionsItemSelected(item));
  }