case class JListWrapper[A](val underlying : java.util.List[A]) extends mutable.Buffer[A] {
    def length = underlying.size
    override def isEmpty = underlying.isEmpty
    override def iterator : Iterator[A] = underlying.iterator
    def apply(i : Int) = underlying.get(i)
    def update(i : Int, elem : A) = underlying.set(i, elem)
    def +=:(elem : A) = { underlying.subList(0, 0).add(elem) ; this } 
    def +=(elem : A): this.type = { underlying.add(elem); this }
    def insertAll(i : Int, elems : Traversable[A]) = { val ins = underlying.subList(0, i) ;  elems.seq.foreach(ins.add(_)) }
    def remove(i : Int) = underlying.remove(i)
    def clear = underlying.clear
    def result = this
}