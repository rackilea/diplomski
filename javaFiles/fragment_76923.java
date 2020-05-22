ptr.setLinkPrev(l.end);
           l.end.setLinkNext(ptr);

           Node tmp=ptr;
           ptr = ptr.getLinkPrev();
           ptr.setLinkNext(l.start);
           l.start.setLinkNext(tmp);