765         public void remove() {
766             if (lastRet < 0)
767                 throw new IllegalStateException();
768             checkForComodification();
769 
770             try {
771                 ArrayList.this.remove(lastRet);
772                 cursor = lastRet;
773                 lastRet = -1;
774                 expectedModCount = modCount;
775             } catch (IndexOutOfBoundsException ex) {
776                 throw new ConcurrentModificationException();
777             }
778         }
779 
780         final void checkForComodification() {
781             if (modCount != expectedModCount)
782                 throw new ConcurrentModificationException();
783         }
784     }