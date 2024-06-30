package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//класс страницы Заказ оформлен
public class OrderIsProcessed {
    private WebDriver driver;
    //Локатор поля Заказ оформлен
    private By orderIsProcessed = By.xpath("//div[text()='Заказ оформлен']");

    public OrderIsProcessed(WebDriver driver) {

        this.driver = driver;
    }

    //метод возвращает true, если поле Заказ оформлен отображено
    public boolean orderIsProcessedTextIsDisplayed() {

        return driver.findElement(orderIsProcessed).isDisplayed();
    }
}