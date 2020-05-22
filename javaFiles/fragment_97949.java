@RestController
@RequestMapping(PrintController.API)
public class PrintController {
    public static final String API="print";

@PostMapping("client",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
        public void export(@RequestBody List<ClientJsonDto> datas,HttpServletResponse response){

            System.out.println(datas);

            // processing the print mechanisme

        }
    }