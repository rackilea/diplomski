extend type Query {
    getFoo: TimelineDTO
}

type TimelineDTO {
    dataReference: [DataReference]
}

type DataReference {
    key: String
    value: String
}