package com.alura;
import com.alura.appium.AppiumDriverConfig;
import io.cucumber.java.pt.*;
import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TC {
    private LoginPageObject telaLogin;
    private CadastroPageObject telaCadastro;
    private String mensagemErro;

    @Given("que estou na tela de login")
    public void que_estou_na_tela_de_login() {
        telaLogin = new LoginPageObject(AppiumDriverConfig.Instance().driver);
        telaLogin.BuscarElementos();
    }

    @When("eu clico no botão de cadastrar usuário")
    public void eu_clico_no_botao_de_cadastrar_usuario() {
        telaLogin.BuscarElementos();

        telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
    }

    @And("preencho os campos de cadastro com nome {string}, senha {string} e confirmação de senha {string}")
    public void preencho_os_campos_de_cadastro_com_nome_senha_e_confirmação_de_senha(String nome, String senha, String confirmacao) {
        telaCadastro.Cadastrar(nome, senha, confirmacao);
    }

    @And("preencho os campos de cadastro com nome {string}")
    public void preencho_os_campos_de_cadastro_com_nome(String nome) {
        telaCadastro.CadastrarSemSenha(nome);
    }

    @And("preencho os campos de cadastro com senha {string} e confirmação de senha {string}")
    public void preencho_os_campos_de_cadastro_com_senha_e_confirmação_de_senha( String senha, String confirmacao) {
        telaCadastro.CadastrarSemNome(senha, confirmacao);
    }

    @Then("devo ser redirecionado para a tela de login novamente")
    public void devo_ser_redirecionado_para_a_tela_de_login_novamente() {
        telaLogin = new LoginPageObject(AppiumDriverConfig.Instance().driver);
        telaLogin.BuscarElementos();
    }

    @Then("devo ver a mensagem de erro informando que as senhas não conferem")
    public void devo_ver_a_mensagem_de_erro_informando_que_as_senhas_não_conferem() {
        mensagemErro = telaCadastro.MensagemErro();
        Assert.assertEquals("Senhas não conferem", mensagemErro);
    }

    @Then("devo ver a mensagem de erro informando que o nome é obrigatório")
    public void devo_ver_a_mensagem_de_erro_informando_que_o_nome_é_obrigatório() {
        mensagemErro = telaCadastro.MensagemErro();
        Assert.assertEquals("Nome é obrigatório", mensagemErro);
    }

    @Then("devo ver a mensagem de erro informando que a senha é obrigatória")
    public void devo_ver_a_mensagem_de_erro_informando_que_a_senha_é_obrigatória() {
        mensagemErro = telaCadastro.MensagemErro();
        Assert.assertEquals("Senha é obrigatória", mensagemErro);
    }

    @Then("devo ver a mensagem de erro informando que a senha deve ter no máximo 20 caracteres")
    public void devo_ver_a_mensagem_de_erro_informando_que_a_senha_deve_ter_no_máximo_20_caracteres() {
        mensagemErro = telaCadastro.MensagemErro();
        Assert.assertEquals("Senha deve ter no máximo 20 caracteres", mensagemErro);
    }

//    @Then("devo ver amensagem de erro, Usuário já Cadastrado")
//    public void devo_ver_a_mensagem_de_erro_usuario_ja_cadastrado() {
//        mensagemErro = telaCadastro.MensagemErro();
//        Assert.assertEquals("Usuário já Cadastrado", mensagemErro);
//    }
}
