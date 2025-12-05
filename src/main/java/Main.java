import model.Apple;
import model.Food;
import model.Meat;
import model.constants.Colour;
import service.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Meat meat = new Meat(5, 100);
        Apple redApples = new Apple(10, 50, Colour.RED);
        Apple greenApples = new Apple(8, 60, Colour.GREEN);
        // Создание массива продуктов
        Food[] food = {meat, redApples, greenApples};
        // Инициализация корзины
        ShoppingCart products = new ShoppingCart(food);
        // Расчет и вывод результатов
        System.out.println("Общая сумма товаров без скидки: " + products.totalFood() + " руб.");
        System.out.println("Общая сумма товаров со скидкой: " + products.totalDiscount() + " руб.");
        System.out.println("Сумма всех вегетарианских продуктов без скидки: " + products.totalVegetarian() + " руб.");
    }
}