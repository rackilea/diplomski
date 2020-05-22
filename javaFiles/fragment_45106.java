@ApiModel
public class Brand{

   private String brandName;
   //...

    @ApiModelProperty(position = 1, required = true, value="")
    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    //...
}