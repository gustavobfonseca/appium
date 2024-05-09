Feature: Cadastro de usuários

  Scenario: Cadastro de usuários com senhas que conferem
    Given que estou na tela de login
    When eu clico no botão de cadastrar usuário
    And preencho os campos de cadastro com nome "Gustavo Bueno", senha "Gustavo432@" e confirmação de senha "Gustavo432@"
    Then devo ser redirecionado para a tela de login novamente


  Scenario: Não posso cadastrar usuário com nome em branco
    Given que estou na tela de login
    When eu clico no botão de cadastrar usuário
    And preencho os campos de cadastro com senha "NovaSenha123@" e confirmação de senha "NovaSenha123@"
    Then devo ver a mensagem de erro informando que o nome é obrigatório


  Scenario: Não posso cadastrar usuário com senha em branco
    Given que estou na tela de login
    When eu clico no botão de cadastrar usuário
    And preencho os campos de cadastro com nome "UsuárioTeste"
    Then devo ver a mensagem de erro informando que a senha é obrigatória


  Scenario: Não posso cadastrar usuário com senha e confirmação de senha com mais de 20 caracteres
    Given que estou na tela de login
    When eu clico no botão de cadastrar usuário
    And preencho os campos de cadastro com nome "UsuárioTeste", senha "SenhaComMaisDeVinteCaractere2s!" e confirmação de senha "SenhaComMaisDeVinteCaractere2s!"
    Then devo ver a mensagem de erro informando que a senha deve ter no máximo 20 caracteres


  Scenario: Posso cadastrar usuário com mesmo nome
    Given que estou na tela de login
    When eu clico no botão de cadastrar usuário
    And preencho os campos de cadastro com nome "Gustavo Bueno", senha "Gustavo432@" e confirmação de senha "Gustavo432@"
    And eu clico no botão de cadastrar usuário
    And preencho os campos de cadastro com nome "Gustavo Bueno", senha "Gustavo432@" e confirmação de senha "Gustavo432@"
    Then devo ser redirecionado para a tela de login novamente


  Scenario: Não consigo cadastrar um usuário com senhas que não conferem
    Given que estou na tela de login
    When eu clico no botão de cadastrar usuário
    And preencho os campos de cadastro com nome "Gustavo Buenod", senha "Senha123@" e confirmação de senha "DIFERENTe123@"
    Then devo ver a mensagem de erro informando que as senhas não conferem
