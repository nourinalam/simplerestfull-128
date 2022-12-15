/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum.praktikum_10;

/**
 *
 * @author user
 */
public class Product {
   private String id;
   private String name;
   private String qty;
   private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public String getQty() {
        return qty;
    }

    public void setQty(String name) {
        this.qty = name;
    }
    
     public String getPrice() {
        return price;
    }

    public void setPrice(String name) {
        this.price = name;
    }
    
}