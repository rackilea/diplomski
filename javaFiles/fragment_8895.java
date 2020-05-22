package com.plugin.jira.api.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Product {
  private String productName;
  private String status;
  private Integer branch;
  private Map<Integer, String> branchStatusMap = new HashMap<>();

  /**
   * @return the productName
   */
  public String getProductName() {
    return productName;
  }

  /**
   * @param productName the productName to set
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
    if (this.branch != null) {
      branchStatusMap.put(this.branch, this.status);
    }
  }

  /**
   * @return the branchStatusMap
   */
  public Map<Integer, String> getBranchStatusMap() {
    return branchStatusMap;
  }

  /**
   * @return the branch
   */
  public Integer getBranch() {
    return branch;
  }

  /**
   * @param branch the branch to set
   */
  public void setBranch(Integer branch) {
    this.branch = branch;
    if (this.status != null) {
      branchStatusMap.put(this.branch, this.status);
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((productName == null) ? 0 : productName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (productName == null) {
      if (other.productName != null)
        return false;
    } else if (!productName.equals(other.productName))
      return false;

    /** make sure that the hasCode is also same for safer side. */
    if (this.hashCode() == other.hashCode()) {
      other.branchStatusMap.put(this.branch, this.status);
    }

    return true;
  }


  public static void main(String[] args) {

    Set<Product> products = new HashSet<>();
    Product p;

    p = new Product();
    p.setProductName("P1");
    p.setStatus("dead");
    p.setBranch(1);
    products.add(p);

    p = new Product();
    p.setProductName("P1");
    p.setStatus("dead");
    p.setBranch(2);
    products.add(p);

    p = new Product();
    p.setProductName("P2");
    p.setStatus("expired");
    p.setBranch(1);
    products.add(p);


    /** now you will get two results in set with map of branches */

    for (Product product : products) {
      System.out.println("Product : " + product.getProductName());
      for (Map.Entry<Integer, String> entry : product.getBranchStatusMap().entrySet()) {
        System.out.println("Branch " + entry.getKey() + " : " + entry.getValue());
      }
      System.out.println("----------------------------------");
    }

  }
}