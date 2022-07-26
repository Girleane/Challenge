package br.com.great;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Validate {

    private final WebDriver driver;
    WebElement buscarElemento = null;

    public Validate(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement elementoByClassName(String elemento) {
        try {
            buscarElemento = driver.findElement(By.className(elemento));
        } catch (NoSuchElementException ignored) {
        }
        return buscarElemento;
    }

    public WebElement elementoByCssSelector (String elemento) {
        try {
            buscarElemento = driver.findElement(By.cssSelector(elemento));
        } catch (NoSuchElementException ignored) {
        }
        return buscarElemento;
    }
    public WebElement elementoById (String elemento) {

        try {
            buscarElemento = driver.findElement(By.id(elemento));
        } catch (NoSuchElementException ignored) {
        }

        return buscarElemento;
    }

    public String text(String elemento) {
        WebElement converter = elementoByCssSelector(elemento);
        return converter.getText();
    }
}
