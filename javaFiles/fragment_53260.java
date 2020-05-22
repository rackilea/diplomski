@RestController
@RequestMapping("/items")
public class ItemController {

    @Autoware
    private ItemRepo repo;

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Item targetItem,  @RequestBody Item sourceItem) {
        BeanUtils.copyProperties(sourceItem, targetItem, "id");
        return ResponseEntity.ok(repo.save(targetItem));
    }
}