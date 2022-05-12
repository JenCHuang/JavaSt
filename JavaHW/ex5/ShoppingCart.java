package ex5;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static void main(String[] args) {

        //實作1.加入二台Notebook("Asus",30000),Notebook("Acer",20000),Food("Cookie",200)到shoppingList中
        List<Product> shoppingList = new ArrayList<Product>();
        shoppingList.add(new Notebook("Asus",30000));
        shoppingList.add(new Notebook("Asus",30000)); // 第二台Asus?s
        shoppingList.add(new Notebook("Acer",20000));
        shoppingList.add(new Food("Cookie",200));
        
        //實作2.利用for迴圈，計算shoppingList中的總金額,並印在Console中
        int sum=0;
        for (Product product : shoppingList) {
        	sum += product.getPrice();
        }
        System.out.println("總金額為: "+sum);

        //實作3.利用for迴圈，計算shoppingList中是Notebook型態的總金額,並印在Console中
        sum=0;
        for (Product product : shoppingList) {
			if (product instanceof Notebook) {
				sum += product.getPrice();
			}
		}
        System.out.println("Notebook型態的商品總金額為: "+sum);


    }
}
