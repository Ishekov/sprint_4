package service;

import model.Discountable;
import model.Food;

public class ShoppingCart {
    private final Food[] products;
    public ShoppingCart(Food[] products) {
        this.products = products;
    }
    //сумма товаров в корзине без скидки
    public double totalFood() {
        double total = 0;
        for (Food item : products) {
            total = total + (item.getAmount() * item.getPrice());
        }
        return total;
    }
    //сумма товаров в корзине скидки
    public double totalDiscount() {
        double total = 0;
        for (Food food : products) {
            double productsPrice = food.getAmount() * food.getPrice();
            if (food instanceof Discountable) {
                Discountable discountableItem = (Discountable) food;
                if (discountableItem.getDiscount() > 0) {
                    productsPrice = productsPrice * (100 - discountableItem.getDiscount()) / 100;
                }
            }
            total = total + productsPrice;
        }
        return total;
    }
    // цена пп питания
    public double totalVegetarian() {

        double total = 0;
        for (Food food : products) {
            if (food.isVegetarian()) {
                total = total + ( food.getAmount() * food.getPrice());
            }
        }
        return total;
    }
}