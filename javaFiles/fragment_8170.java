email = new->email_object();
remote_mailbox = new->imap_object_creator(username, password, ...)

while (email = remote_mailbox->download_next_email) {  // this downloads the next email
  foreach part_type (email->parts->next) {    // this iterates over the parts of the email
    if( part_type == 'attachment' )  {  // not sure if this is it exactly, but you'll find it in the mime-type
      //hooray!  you've found an attachment.  do what you will with it
    }
  }
}