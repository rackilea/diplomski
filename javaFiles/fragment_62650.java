ch#1 -> {#method<channel.open>(out-of-band=), null, ""}
ch#1 <- {#method<channel.open-ok>(channel-id=), null, ""}
ch#1 -> {#method<confirm.select>(nowait=false), null, ""}
ch#1 <- {#method<confirm.select-ok>(), null, ""}
ch#1 -> {#method<basic.publish>(ticket=0, exchange=node.confirm.publish, routing-key=, mandatory=false, immediate=false), #contentHeader<basic>(content-type=string/utf8, content-encoding=null, headers=null, delivery-mode=2, priority=null, correlation-id=null, reply-to=null, expiration=null, message-id=null, timestamp=null, type=null, user-id=null, app-id=null, cluster-id=null), "some message"}
ch#1 <- {#method<channel.close>(reply-code=404, reply-text=NOT_FOUND - no exchange 'node.confirm.publish' in vhost '/', class-id=60, method-id=40), null, ""}
ch#2 -> {#method<channel.open>(out-of-band=), null, ""}
ch#2 <- {#method<channel.open-ok>(channel-id=), null, ""}
ch#2 -> {#method<confirm.select>(nowait=false), null, ""}
ch#2 <- {#method<confirm.select-ok>(), null, ""}