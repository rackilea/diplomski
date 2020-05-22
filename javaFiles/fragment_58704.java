@PatchMapping("/tradeManagers/{tradeManagerId}")
Map<String, Object> newTradeManager(@RequestBody Map<String, Object> tradeManagerMap, 
    @PathVariable(name = "tradeManagerId") String trademanagerId) {
    Trademanager  tradeManger = tradeManagerRepo.findById(tradeManagerId);
    BeanUtils.copyProperties(trademanager, tradeManagerMap);
    return tradeManagerMap;
}