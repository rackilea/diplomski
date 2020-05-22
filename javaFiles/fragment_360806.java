public boolean equals(LinkedList item){
  if (this == item){
     return true; // It's the same object
  }

  // Add some null checks here, I'm lazy

  if (this.visited && item.visited && this.contents.equals(item.contents){
     this.visited = false; //Unset
     item.visited = false;
     return true;
  }
  if (this.visited && !item.visited){
      this.visited = false;
      return false;
  }
  if (!this.visited && item.visited){
      item.visited = false;
      return false;
  }
  if (!this.visited && !item.visited && this.visited.contents.equals(item.contents){
      this.visited = true;
      item.visited = true;
      boolean ret = this.next.equals(item.next);
      this.visited = false;
      item.visited = false;
      return ret;
  }

  // Contents not equal
  return false;
}