package com.mphasis.training;

import java.util.Scanner;

import com.mphasis.training.Dao.ProductDao;
import com.mphasis.training.entities.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	
    	Scanner sc= new Scanner(System.in);
    	ProductDao pdao= new ProductDao();
    	System.out.println("1.add product 2. update product 3.delete product "+"4.retrive Product By Id 5.retriveall 6.retrive By cost");
    	
    	switch(sc.nextInt()) {
    	
    	case 1 : System.out.println("Add Product");
    	          Product p1 = new Product(sc.nextInt(),sc.next(),sc.nextDouble(),sc.nextInt());
    	         pdao.insertProduct(p1);
    	         System.out.println("Product successfully added");
    	case 2 : System.out.println("Enter the product id to update");
                     int pid=sc.nextInt();
                     Product update=pdao.retriveProductById(pid);
                      System.out.println("Enter the product cost & quantity to update");
                       update.setCost(sc.nextDouble());
                       update.setQty(sc.nextInt());
                       pdao.updateProduct(update);
                       System.out.println("Product updated successfully");
                       System.out.println(pdao.retriveProductById(pid));
    	           
    	case 3 :
    		      System.out.println("enter product id to delete");
    		       pdao.deleteProduct(sc.nextInt());
    		       System.out.println("Product deleted successfully");
    	            break;
    	case 4 : System.out.println("Search by id");
    	        System.out.println( pdao.retriveProductById(sc.nextInt()));
    	         
    	        
    	        
    	case 5 : System.out.println("List of all Products");
    	         pdao.retriveAllProduct().forEach(p->System.out.println(p));
    	         break;
    	case 6 :
    		        System.out.println("Enter product cost");
    		          double cost=sc.nextDouble();
    		           Product getcost = (Product) pdao.retriveProductByCost(cost);
    		           System.out.println(getcost);
    	         
    	case 7:System.out.println("Thank you");
    	 System.exit(0);
    	 default:System.out.println("INVALID CHOICE");
    	}
    	
    }
}
