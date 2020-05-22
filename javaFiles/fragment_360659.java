byte[] hash = md5(url);
if(bloomFilter.maybe(hash)){
  checkTheFile(hash);
}else{
 visitUrl(url);
 addToFile(hash);
 addToBloomFilter(hash);
}