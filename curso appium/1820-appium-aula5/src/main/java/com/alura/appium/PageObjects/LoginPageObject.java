package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPageObject extends PageObjectBase {

    private MobileElement botaoCadastro;
    private final By erroID;

    public LoginPageObject(AppiumDriver driver){
        super(driver);
        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");

    }
    @Override
    public void BuscarElementos(){
         botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }


    public CadastroPageObject IrParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);
    }
}
