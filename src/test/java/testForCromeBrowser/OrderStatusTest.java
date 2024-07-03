package testForCromeBrowser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.*;

import static org.junit.Assert.assertTrue;


//Класс с автотестами
@RunWith(Parameterized.class)
public class OrderStatusTest extends ConnectChrome {

    private final String button;
    private final String name;
    private final String secondName;
    private final String address;
    private final String telephone;
    private final String newDate;
    private final int days;
    private final String newColor;
    private final String newComment;

    //конструктор тест-класса
    public OrderStatusTest(String button, String name, String secondName, String address, String telephone, String newDate, int days, String newColor, String newComment) {
        this.button = button;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.telephone = telephone;
        this.newDate = newDate;
        this.days = days;
        this.newColor = newColor;
        this.newComment = newComment;
    }

    //набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"up", "Иван", "Иванов", "Московская", "89209575144", "18.04.1996", 1, "black", "Скорее везите, уже не могу!"},
                {"down", "Петр", "Петров", "Ленинградская", "89106133202", "15.03.2003", 5, "grey", "Мне самый безысходный из всех"},

        };
    }

    @Test
    public void enterOrderAllDataTest() {
        //создаю объект главной страницы
        HomePage objHomePage = new HomePage(driver);
        //обращаюсь к сайту Самоката
        objHomePage.openScooterPage();
        //выбираю кнопку Заказать для клика
        objHomePage.chooseButton(button);

        //создаю объект страницы Для кого самокат
        new OrderForm(driver)
                //вызываю метод для ввода данных на странице Для кого самокат
                .enterOrderAll(name, secondName, address, telephone);
        //создаю объект страницы Про аренду
        new RentOrderForm(driver)
                //вызываю метод для ввода данных на странице Про аренду
                .enterAllDataRentOrder(newDate, days, newColor, newComment);
        //создаю объект страницы Хотите оформить заказ?
        new WishOrder(driver)
                //нажимаю кнопку Да в окне Хотите оформить заказ?
                .clickOkButton();
        //создаю объект страницы Заказ оформлен
        OrderIsProcessed objOrderIsProcessed = new OrderIsProcessed(driver);
        //проверяю, что поле "Заказ оформлен" отображается
        assertTrue(objOrderIsProcessed.orderIsProcessedTextIsDisplayed());
    }

}