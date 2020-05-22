enum Utility {
    static func getImage(_ id: String, attributeName: String, completion: (_ image: UIImage) -> Void) {
        // get image here
        let image = UIImage()
        // pass image to handler
        completion(image)
    }
}

Utility.getImage("42", attributeName: "photo") { image in
    // your inline code with image processing
    print(image.description)
}