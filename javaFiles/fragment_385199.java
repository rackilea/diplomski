extension String {
    func indexOf(target: String) -> Int {
        if let range = self.rangeOfString(target) {
            return self.startIndex.distanceTo(range.startIndex)
        } else {
            return -1
        }
    }
    func indexOf(target: String, startIndex: Int) -> Int {
        let startRange = self.startIndex.advancedBy(startIndex)
        if let range = self.rangeOfString(target, options: .LiteralSearch, range: startRange..<self.endIndex) {
            return self.startIndex.distanceTo(range.startIndex)
        } else {
            return -1
        }
    }
}

let end = myString.indexOf("{", startIndex: myString.indexOf("{") + 1)