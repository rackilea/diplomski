@Service
public class VendorServiceImpl implements  VendorService{

     @Autowired
     private VendorDao vendorDao; 

     @Transactional
     public List<Vendor> listVendors(){
         return vendorDao.listVendors();
     }
}