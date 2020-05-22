func hashString(s string) string {
    dataArr := md5.Sum([]byte(s))
    data := dataArr[:]
    fmt.Println(data)
    output := make([]byte, len(data)/4)
    for i := 0; i < len(output); i += 4 {
        for j := 0; j < len(data); j++ {
            output[i] ^= data[i+j]
            fmt.Print(output[i])
        }
    }
    return getHexString(output)
}