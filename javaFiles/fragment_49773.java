List<Response> responses = new ArrayList<>();

Pipeline p = jedis.pipelined();
for (int id: ids) {
responses .add(p.get(id));
}
p.sync();

for(Reponse response : responses){
Object o = response.get();
}