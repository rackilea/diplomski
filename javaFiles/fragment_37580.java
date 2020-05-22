case class LogValues( time_stamp    : String
                    , action        : Option[String]
                    , protocol      : Option[String]
                    , connection_id : Option[String]
                    , ips           : String
                    , ports         : String
                    )

log_Line match {
  case logRE(ts,act,ptcl,cid,sip,sprt,dip,dprt) =>
    Some(LogValues( ts
                  , Option(act)
                  , Option(ptcl)
                  , Option(cid)
                  , s"$sip/$dip"
                  , s"$sprt/$dprt" ))
  case _ => /* log line doesn't fit pattern */
    None
}