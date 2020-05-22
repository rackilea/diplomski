for (int i = 0; i < newKey; i++){
            if (i < maxHeap)
                newIndexer[i] = this.Indexer[i];
            else{
                System.out.println(i);
                newIndexer[i] = new Handle ();
                newIndexer[i].index = (int)Double.POSITIVE_INFINITY;
                newIndexer[i].status = false;
            }
        }