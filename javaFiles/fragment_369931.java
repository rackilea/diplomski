public void delete(String deleteName) {



        LinkedListNode current = head;
        if(head==null){
            System.out.println("Nothing to delete from the list! Insert data.");
        }
        // for head
        else if(current.getName().equals(deleteName)){
            head=current.getNext();
        }
        // for tail
        else if(findTail().getName().equals(deleteName)){
            while(current.getNext().getNext()!=null ){
                current = current.getNext();
            }
            current.setNext(null);
        }
        else{
            while(!current.getNext().getName().equals(deleteName)){
                current=current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        System.out.println("");
        System.out.println(deleteName +" has been deleted from the list.");

    }   // end of delete()