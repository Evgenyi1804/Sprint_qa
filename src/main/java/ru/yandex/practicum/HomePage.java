package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// класс главной страницы
public class HomePage {
    private WebDriver driver;
    //локатор для кнопки заказать сверху
    private By highOrderButton =By.xpath(".//button[(@class ='Button_Button__ra12g' and text()='Заказать')]");
    //локатор для кнопки заказать снизу
    private By lowOrderButton = By.className("Button_Middle__1CSJM");
//локаторы для выпадающего списка
private By buttonsQuestionsList_0 = By.id("accordion__heading-0");
    private By buttonsQuestionsList_1 = By.id("accordion__heading-1");
    private By buttonsQuestionsList_2 = By.id("accordion__heading-2");
    private By buttonsQuestionsList_3 = By.id("accordion__heading-3");
    private By buttonsQuestionsList_4 = By.id("accordion__heading-4");
    private By buttonsQuestionsList_5 = By.id("accordion__heading-5");
    private By buttonsQuestionsList_6 = By.id("accordion__heading-6");
    private By buttonsQuestionsList_7 = By.id("accordion__heading-7");
 // нужен массив локаторов
 private By[] buttonsQuestionsArray = {buttonsQuestionsList_0, buttonsQuestionsList_1, buttonsQuestionsList_2, buttonsQuestionsList_3, buttonsQuestionsList_4, buttonsQuestionsList_5, buttonsQuestionsList_6, buttonsQuestionsList_7};
 // локаторы ответов в выпадающем списке
 private By answersQuestionsList_0 = By.id("accordion__panel-0");
    private By answersQuestionsList_1 = By.id("accordion__panel-1");
    private By answersQuestionsList_2 = By.id("accordion__panel-2");
    private By answersQuestionsList_3 = By.id("accordion__panel-3");
    private By answersQuestionsList_4 = By.id("accordion__panel-4");
    private By answersQuestionsList_5 = By.id("accordion__panel-5");
    private By answersQuestionsList_6 = By.id("accordion__panel-6");
    private By answersQuestionsList_7 = By.id("accordion__panel-7");
//нужен массив ответов
private By[] answersQuestionsArray = {answersQuestionsList_0, answersQuestionsList_1, answersQuestionsList_2, answersQuestionsList_3, answersQuestionsList_4, answersQuestionsList_5, answersQuestionsList_6, answersQuestionsList_7};
    private String[] expectedAnswersQuestions = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

public HomePage(WebDriver driver) {

    this.driver = driver;
}

//открыть главную страницу Самоката
public void openScooterPage() {
    driver.get("https://qa-scooter.praktikum-services.ru/");
}
// пролистать до списка вопросов и нажать нужный
public void clickButtonsQuestions(int listIndex) {
    By locator = buttonsQuestionsArray[listIndex];
    WebElement element = driver.findElement(locator);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//ожидание?
    driver.findElement(locator).click();
}
//нажать кнопку Заказать сверху  главной страницы
public HomePage highOrderButtonClick() {

    driver.findElement(highOrderButton).click();

    return null;
}

//нажать кнопку Заказать внизу главной страницы
public HomePage lowOrderButtonClick() {
    WebElement element = driver.findElement(lowOrderButton);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    driver.findElement(lowOrderButton).click();
    return this;
    }
    //выбор кнопки заказать
    public HomePage chooseButton(String button) {
        if (button.equals("up")) {
          return  highOrderButtonClick();
                                }
        else if (button.equals("down")) {
        return    lowOrderButtonClick();
                  }
        return null;
       }
//метод для получения текста ответов
public String getAnswersQuestions(int listIndex) {
    By locator = answersQuestionsArray[listIndex];
    return driver.findElement(locator).getText();
}

//метод для сравнения текстовых ответов с ожидаемыми ответами
public boolean contentIsDisplayed(int listIndex) {
    By locator = answersQuestionsArray[listIndex];
    String expectedAnswersText = expectedAnswersQuestions[listIndex];
   new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    return driver.findElement(locator).isDisplayed() && getAnswersQuestions(listIndex).equals(expectedAnswersText);
}


}