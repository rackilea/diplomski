@Override
 public boolean equals(Object obj) {
    if( !(obj instanceof RedditThing){
        return false;
    }

   RedditThing redditThing2 = (RedditThing)obj;
    return compareEquality(this,redditThing2);
 }




static boolean compareEquality(RedditThing one, RedditThing two){
    //Compare attributes of two objects here and return true/false depending 
      // on comparison
}