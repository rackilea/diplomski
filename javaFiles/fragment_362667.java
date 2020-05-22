class Course: Decodable {
    let id: Int
    let name: String
    let link: String
    let imageUrl: String?

    private enum CourseCodingKeys: String, CodingKey {
        case id = "id"
        case name = "name"
        case link = "link"
        case imageUrl = "imageUrl"
    }

    required init(from decoder: Decoder) throws {
        let courseContainer = try decoder.container(keyedBy: CourseCodingKeys.self)
        self.id = try courseContainer.decode(Int.self, forKey: .id)
        self.name = try courseContainer.decode(String.self, forKey: .name)
        self.link = try courseContainer.decode(String.self, forKey: .link)
        self.imageUrl = try courseContainer.decodeIfPresent(String.self, forKey: .imageUrl)
    }
}