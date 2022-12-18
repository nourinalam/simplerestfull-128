/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum.praktikum_10;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
//method request Http Get menggunakan HashMap
@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
      honey.setId("1");
      honey.setName("Honey");
      honey.setQty("1");
      honey.setPrice("Rp. 20000");
      productRepo.put(honey.getId(), honey);
      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almond");
      almond.setQty("1");
      almond.setPrice("Rp. 15000");
      productRepo.put(almond.getId(), almond);
      
      
    }
    
    //Method ini untuk menghapus produk
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      productRepo.remove(id);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
   
   //Method ini untuk memperbarui data (Update)
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
     
       //Membuat validasi ketika product tidak ditemukan
       if(!productRepo.containsKey(id)){
            return new ResponseEntity<>("Product Not Found, Please check again", HttpStatus.NOT_FOUND);
        }
       //Kondisi jika product berhasil di edit dan di update
        else{
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
            return new  ResponseEntity<>("Product is updated Successfully",HttpStatus.OK);
        }
        
    }
   
   //Method untuk create data product
    @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
      //Membuat Validasi id product jika id product yang akan ditambahkan sudah ada atau id-nya sama
       if(productRepo.containsKey(product.getId())){
            return new ResponseEntity<>("ID Product Cannot be the Same, please check again", HttpStatus.OK);
        }
       //Kondisi jika product berhasil ditambahkan
        else{
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created Successfully", HttpStatus.CREATED);
        }
    }
   //Method untuk mendapatkan API product
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
}