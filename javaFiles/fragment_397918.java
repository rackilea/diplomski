import (
    "encoding/json"
    "bytes"
    "fmt"
    "io/ioutil"
    "net/http"
)

func main() {

    url:=fmt.Sprintf("https://<Server BitBucket>/rest/api/1.0/projects/<PROJECT WHERE REPO TO BE CREATED>/repos");
   jsonData := map[string]string{"name":"<REPONAME>","scmID":"git","forkable":"true"}  
    jsonValue,_:=json.Marshal(jsonData)
    req, err := http.NewRequest("POST", url, bytes.NewBuffer(jsonValue))
    req.Header.Set("Content-Type", "application/json")
        req.SetBasicAuth("<USERNAME>", "<PASSWORD>")
    fmt.Println("++",req)

    client := &http.Client{}
    resp, err := client.Do(req)
    if err != nil {
        panic(err)
    }

    defer resp.Body.Close()

    fmt.Println("response Status:", resp.Status)
    fmt.Println("response Headers:", resp.Header)
    body, _ := ioutil.ReadAll(resp.Body)
    fmt.Println("response Body:", string(body))
    }