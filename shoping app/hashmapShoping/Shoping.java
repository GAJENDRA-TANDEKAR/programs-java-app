package hashmapShoping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shoping {
    boolean active = true ;


    Scanner sc = new Scanner(System.in);

    //ArrayList<CRUD_Operation.Product> list = new ArrayList<>();

    HashMap<String, hashmapShoping.Product>  list = new HashMap<String, hashmapShoping.Product>();
    HashMap<String, hashmapShoping.Product>  cartProducts = new HashMap<String, hashmapShoping.Product>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Welcome to shoping app");

        Shoping  shoping = new Shoping();

        while (shoping.active){
            System.out.println(" press  1 product name for addd ");
            System.out.println("  press 2 display all product");
            System.out.println("  press 3  for add to cart");
            System.out.println("  press 4 to display cart product");
            System.out.println("  press 5 checkout  or total amount ");


            int input = sc.nextInt();
            switch (input){
                case 1:
                    shoping.addproduct();
                    break;
                case 2:
                    shoping.displayproduct();
                    break;
                case 3:
                    shoping.addToCart();
                    break;
                case 4:
                    shoping.displayCartProduct();
                    break;
                case 5:
                    shoping.chackOUT();
                    shoping.active = false;
                    break;


                default:
                    break;
            }
        }





    }


    public  void addproduct(){
        Product product = new Product();
        System.out.println(" enter name of product");
        product.setName(sc.next());
        System.out.println(" enter price of product ");
        product.setPrice(sc.nextFloat());
        System.out.println(" enter id of product");
        product.setId(sc.next());

        System.out.println(" add successfully");

        list.put(product.getId(), product);
    }

    public void displayproduct(){
     //   System.out.println(list);
//        System.out.println(list.get("TEA1"));
        for (Map.Entry m: list.entrySet()){
            System.out.println(m.getKey()+" : "+m.getValue());
        }

    }

    public  void addToCart(){
        System.out.println(" product is avaible");
        String productName ;
//        HashMap<String, hashmapShoping.Product>  cartProducts = new HashMap<String, hashmapShoping.Product>();

        for (Map.Entry m: list.entrySet()){
            System.out.println(m.getKey()+" : "+m.getValue());

        }
        System.out.println(" please enter product name to add to cart");
        productName = sc.next();

        cartProducts.put(productName,list.get(productName));
    }
    public void displayCartProduct(){
        System.out.println(" your cart products");
       // System.out.println(cartProducts + " ");

        for (Map.Entry m: cartProducts.entrySet()){
            System.out.println(m.getKey()+" : "+m.getValue());
        }
    }
    public  void  chackOUT (){
        displayCartProduct();
       float totalAmount =0;
        for (Map.Entry m: cartProducts.entrySet()){
           // System.out.println(m.getKey()+" : "+m.getValue());

            Product p1 = (Product) m.getValue();
//            System.out.println(p1.getPrice());
            totalAmount=totalAmount+ p1.getPrice();
        }
        System.out.println(" Total amount"+totalAmount+ " ");
    }
}
