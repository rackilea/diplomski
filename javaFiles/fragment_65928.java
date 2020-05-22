func request(url:String, success:@escaping(Any) -> Void, failure:@escaping(Any?) -> Void)
{
    let task = URLSession.shared.dataTask(with: URL.init(string: url)!) { (data, response, error) in
        if let responseError = error
        {
            failure(responseError)
        }
        else if let responseData = data  //Make additional checks if there is an error
        {
            success(responseData)  //Call when you are sure that there is no error
        }
        else
        {
            failure(nil)
        }
    }
    task.resume()
}