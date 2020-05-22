package viewhelpers

import play.twirl.api.Html // play.api.templates.Html for 2.2

object ViewExtension {

    def renderTrace[T <: Any](trace: ImmutableSortedMap[OffsetDateTime, Option[T]], renderer: (T) => Html): Html = ...

}