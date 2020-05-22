import play.api.libs.iteratee._
import scala.concurrent._

object MergeEnums {
  def apply[E: Ordering](enums: Enumerator[E]*)(implicit executor: ExecutionContext) = new Enumerator[E] {
    def apply[A](iter: Iteratee[E, A]) = {
      case class IterateeReturn(o: Option[(Promise[Promise[IterateeReturn]], E)])

      val failP = Promise()
      val failPF = failP.future
      val initState = Future.traverse(enums) { enum =>
        val p = Promise[IterateeReturn]()
        enum.run(Iteratee.foldM(p) { (oldP: Promise[IterateeReturn], elem: E) =>
          val p = Promise[Promise[IterateeReturn]]()
          oldP success IterateeReturn(Some(p, elem))
          p.future
        } map { promise =>
          promise success IterateeReturn(None)
        }) onFailure { case t => failP failure t }
        p.future
      } map (_.map(_.o).flatten.toList)

      Enumerator.unfoldM(initState) { fstate =>
        Future.firstCompletedOf(Seq(fstate, failPF)) map { state =>
          state.sortBy(_._2) match {
            case Nil => None
            case (oldP, elem) :: tail =>
              val p = Promise[IterateeReturn]()
              oldP success p
              val newState = p.future.map(_.o.map(_ :: tail).getOrElse(tail))
              Some(newState, elem)
          }
        }
      } apply iter
    }
  }
}