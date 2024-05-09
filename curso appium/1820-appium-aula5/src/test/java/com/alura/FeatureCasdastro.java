package com.alura;

import static org.junit.Assert.assertTrue;

import com.alura.appium.AppiumDriverConfig;
import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;

public class FeatureCasdastro {

    private String nome;
    private String email;
    private String senha;
    private String confirmarSenha;
    private String senhaMaisDe20;
    private String senhaMenosDe5;

    public void geradorDados() {
        Faker fakeData = new Faker();
        nome = fakeData.name().name();
        senha = fakeData.internet().password(5, 20, true, true);
        confirmarSenha = fakeData.internet().password(5, 20, true, true);
        senhaMaisDe20 = fakeData.internet().password(21, 30, true, true);
        senhaMenosDe5 = fakeData.internet().password(1, 5, true, true);
    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        geradorDados();

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar(nome, senha, senha);
        telaLogin.BuscarElementos();

    }


    @Test
    public void posso_cadastrar_usuario_com_nome_que_ja_existe() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        posso_cadastrar_usuario_com_senhas_que_conferem();
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar(nome, senha, senha);
        telaLogin.BuscarElementos();

    }

    @Test
    public void nao_posso_cadastrar_usuario_com_nome_em_branco() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        geradorDados();

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.CadastrarSemNome(senha, senha);
        telaCadastro.BuscarElementos();

    }

    @Test
    public void nao_posso_cadastrar_usuario_com_senha_em_branco() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        geradorDados();

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.CadastrarSemSenha(nome);
        telaCadastro.BuscarElementos();
    }

    @Test
    public void nao_posso_cadastrar_usuario_com_senhas_com_mais_de_20_caracteres() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        geradorDados();

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar(nome, senhaMaisDe20, senhaMaisDe20);
        telaCadastro.BuscarElementos();
    }

    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        geradorDados();

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar(nome, senha, confirmarSenha);
        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
    }

}
