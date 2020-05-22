func ImageUpload(_ image: UIImage) {
guard image.jpegData(compressionQuality: 0.9) != nil else {
            self.dismiss(animated: true, completion: nil)
            return
        }
        let imagedata = image.jpegData(compressionQuality: 0.9)
        let uploadDict = ["num": "123456789"] as [String:String]
        let headers: HTTPHeaders = ["key":"val"] //  Use this if you need to add api headers
        Alamofire.upload(multipartFormData: { MultipartFormData in

            MultipartFormData.append(imagedata!, withName: "image" , fileName: "image.jpg" , mimeType: "image/jpg")
            for(key,value) in uploadDict{
                MultipartFormData.append(value.data(using: String.Encoding.utf8)!, withName: key)}   
        },to: "\(url)", headers: headers, encodingCompletion: {
            EncodingResult in
            switch EncodingResult{
            case .success(let upload, _, _):
                upload.responseJSON { response in
                    guard let json = response.result.value! as? [String: Any] else {
                        return
                    }
                    print(json)
                }
            case .failure(let encodingError):
                print("ERROR RESPONSE: \(encodingError)")
            } 
        })
    }