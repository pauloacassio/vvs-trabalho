# Trabalho para a disciplina de Validação e Verificação de Sistemas 
Trabalho desenvolvido por Paulo Acassio Martins Oliveira para a disciplina de Validação e Verificação de Sistemas lecionada pelo professor Rodrigo Prestes Machado do Instituto Federal do Rio Grande do Sul (IFRS).
Para a realização dos testes, foi desenvolvido um backend em quarkus simulando uma aplicação para fazer cadastro de cafeterias e cafés.

# Plano de Testes
Para o desenvolvimento do trabalho final, foram pedidas as seguintes atividades:

1 – Escreva um plano de teste, ou seja, um documento que descreva cada teste juntamente com as entradas e saídas esperadas. Uma observação, escreva o plano no formato Markdown (.md) e versione no repositório do seu projeto.
2 – Implemente uma verificação estática no projeto
3 – Implemente um conjunto de testes unitários
4 – Implemente testes de componentes (API) e/ou testes de sistema (Selenium ou Cypress)
5 – Configure um ambiente de integração contínua de sua escolha, por exemplo, Github Actions, Jekins, Travis, Circle-CI, GitLab, entre outros.

# Verificação Estática
A verificação estática do projeto foi feita atráves das extensões do PMD e Sonarlint do VS Code. O PMD foi utilizado com o arquivo pmd.xml para fazer a verificação dos códigos que não foram comentados, já o Sonarlint, foi utilizado para melhorar a qualidade do código.

# Testes Unitários
Os testes unitários foram implementados nas classes "CafeteriaTest" e na "CafeTest" onde foram testados os getters e setters das mesmas.

# Testes de Componentes
Os testes de componetes foram implementados nas classes "CafeteriaResourceTest" e na "CafeResourceTest" onde foram testados os endpoints do CRUD das classes.

# Ambiente de Integração Contínua
Foi escolhido o Github Actions para fazer o ambiente de integração, nele a cada vez que for feito um push no código, a aplicação terá um build no Github Actions.