@Autowired
OrderRangeService orderRangeService;

@GetMapping("/amountsFromAndTo")
@ResponseBody
public String getAmounts(@RequestParam int startAmt, @RequestParam int endAmt) {
    List<OrderEntity> orderEntityL = orderRangeService.findAmountsBetween(startAmt, endAmt);
    return orderEntityL.toString();
}