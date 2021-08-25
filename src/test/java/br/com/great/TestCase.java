package br.com.great;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase {
    private static WebDriver driver;
    private final Validate validar = new Validate(driver);

    @BeforeAll
    public static void abrirURL() {
        Driver webDriver = new Driver();
        driver = webDriver.open();
    }

    @Test
    public void clicarEmCadastrar() {
        String nameElement = "button_menu";
        WebElement elemento = validar.elementoByClassName(nameElement);
        Assertions.assertNotNull(elemento);
        elemento.click();
    }

    @Test
    public void validarCamposDeCadastro() {
        Assertions.assertTrue(validar.text("h1").contains("Cadastre-se"));

        Assertions.assertTrue(validar.text(".form-group--email>.text-gray").contains("Seu email"));

        Assertions.assertTrue(validar.text(".form-group--repeat-password>.text-gray").contains("Repetir senha"));

        Assertions.assertTrue(validar.text(".form-group--password>.text-gray").contains("Senha"));
    }

    @Test
    public void preencherCamposDeCadastro(){
        String emailIn = "c" + "1235" + "@gmail.com";
        String senhaIn = "12345678";

        WebElement email = validar.elementoById("email");
        Assertions.assertNotNull(email);

        WebElement senha = validar.elementoById("password");
        Assertions.assertNotNull(senha);

        WebElement confirmarSenha = validar.elementoById("passwordConfirmation");
        Assertions.assertNotNull(confirmarSenha);

        email.sendKeys(emailIn);
        senha.sendKeys(senhaIn);
        confirmarSenha.sendKeys(senhaIn);
    }

    @Test
    public void marcarBoxDeTermos(){
        WebElement termos = validar.elementoById("termsOfUse");
        Assertions.assertNotNull(termos);
        termos.click();
    }

    @Test
    public void clicarEmComecarAUsar(){
        WebElement comecarAUsar = validar.elementoByCssSelector(".btn.btn-primary.btn-rounded");
        Assertions.assertNotNull(comecarAUsar);
        comecarAUsar.click();
    }

    @Test
    public void validarMensagemDeAguarde(){
        String mensagem = "Aguarde, estamos preparando sua conta...";
        Assertions.assertTrue(validar.text("signup__status-title").contains(mensagem));
    }

    @Test
    public void validarMensagemDeSucesso(){
        String mensagem = "Parabéns! O Organizze já está preparado para você!"
                + "Enviamos um e-mail para sua caixa de entrada. "
                + "Confirme seu cadastro para receber um e-mail importante da nossa equipe.";

        Assertions.assertTrue(validar.text(".signup__success-box").contains(mensagem));
    }

    @Test
    public void clicarEmComecarAgora(){
        WebElement comecarAgora = validar.elementoByCssSelector(".signup__success-box>.btn");
        Assertions.assertNotNull(comecarAgora);
        comecarAgora.click();
    }

    @AfterAll
    public static void close() {
        driver.close();
    }

}
