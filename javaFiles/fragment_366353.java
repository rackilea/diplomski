self.showLoadingHUD()
                Alamofire.request(.GET, data, parameters: nil)
                    .response { (request, response, data, error) in
                        print(data) // if you want to check data in debug window.
                        let Result = NSString(data: data!, encoding: NSUTF8StringEncoding)
                        Result!.stringByReplacingOccurrencesOfString("\"", withString: "")
                        if(newResult == "1"){
                            self.navigationController!.popViewControllerAnimated(true)
                            JLToast.makeText("Success").show()
                        }
                        else if (newResult == "0"){
                            JLToast.makeText("Failed").show()
                        }

                        self.hideLoadingHUD()