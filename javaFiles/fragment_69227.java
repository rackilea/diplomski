String s = "08:28:57,990 DEBUG [http-0.0.0.0-18080-33] [tester] [1522412937602-580613] [TestManager] ABCD: loaded 35 test accounts"
def res = s =~ /\b([A-Z]{4}):[^\]\[\d]*(\d{1,5})\b/
if (res.find()) {
    println "${res[0][1]}, ${res[0][2]}"
} else {
    println "not found"
}