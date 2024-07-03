package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


// класс формы заказа
public class OrderForm {
    private WebDriver driver;
    //локатор для поля Имя
    private By orderName = By.xpath("//input[@placeholder='* Имя']");
    //локатор для поля Фамилия
    private By orderSecondName = By.xpath("//input[@placeholder='* Фамилия']");
    //локатор для поля Адрес куда везти
    private By orderAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для поля Станция метро
    private By orderStation = By.className("select-search__input");
    //локатор селектора Станция метро
    private By orderSelectorStation = By.className("select-search__select");
    //локатор для поля Телефон
    private By orderTelephone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки Далее
    private By orderButtonFurther = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    public OrderForm(WebDriver driver) {

        this.driver =driver;
}
    //метод для ввода Имени
    public void enterOrderName(String name) {

        driver.findElement(orderName).sendKeys(name);
    }

    //метод для ввода Фамилии
    public void enterOrderSecondName(String secondName) {

        driver.findElement(orderSecondName).sendKeys(secondName);
    }

    //метод для ввода Адреса
    public void enterOrderAddress(String address) {
        driver.findElement(orderAddress).sendKeys(address);

    }

    //метод обращения к полю Станция метро и выбора станции
    public void clickOrderStation() {
        driver.findElement(orderStation).click();
        driver.findElement(orderSelectorStation).isDisplayed();
        driver.findElement(orderStation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    //метод для ввода номера Телефона
    public void enterOrderTelephone(String telephone) {
        driver.findElement(orderTelephone).sendKeys(telephone);

    }

    //кликнуть по кнопке Далее на старнице Для кого самокат
    public void clickOrderButtonFurther() {

        driver.findElement(orderButtonFurther).click();
    }

    //общий метод для ввода всего и нажатие кнопки Далее
    public OrderForm enterOrderAll(String name, String secondName, String address, String telephone) {
        enterOrderName(name);
        enterOrderSecondName(secondName);
        enterOrderAddress(address);
        clickOrderStation();
        enterOrderTelephone(telephone);
        clickOrderButtonFurther();
        return this;

    }
}
