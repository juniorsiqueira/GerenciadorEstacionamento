/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciadorEstacionamento;

/**
 *
 * @author JuniorSiqueira
 */
public class Funcionario extends Pessoa {

  protected String login;
  protected String senha;

  public String getLogin() {
    return login;
  }

  public String getSenha() {
    return senha;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Funcionario(String nome, String cpf, String end, String login, String senha) {
    this.nome = nome;
    this.cpf = cpf;
    this.end = end;
    this.login = login;
    this.senha = senha;
  }

    public Funcionario() {
    }
  
  

  @Override
  public String toString() {
    return "Funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", endereco=" + end + ", login=" + login + ", senha=" + senha + '}';
  }
}