struct usernotifcatons {

var body: String = ""
var detail: String = ""
var notiImage: String = ""
var title: String = ""


init(notificationData: [String:Any]) {

let body = notificationData["body"] as? String ?? ""
self.body = body

let detail = notificationData["detail"] as? String ?? ""
self.detail = detail

let notiImage = notificationData["notiImage"] as? String ?? ""
self.notiImage = notiImage

let title = notificationData["title"] as? String ?? ""
self.title = title
 }

}