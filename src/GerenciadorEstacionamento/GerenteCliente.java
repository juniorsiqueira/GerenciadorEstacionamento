package GerenciadorEstacionamento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thiagomello
 */
public class GerenteCliente {

  //GravaGerenciador Persistencia.getInstance().getGravaGerenciador() = new GravaGerenciador();
  private float valor = 1;//admite-se o valor do estacionamento por 1 real;
  private float auxiliar;

  public void cadastrarClienteFisico(ClienteFisico c) throws FileNotFoundException, IOException {
    Persistencia.getInstance().getGravaGerenciador().getClientesfisico().add(c);
    Persistencia.getInstance().gravarDados();


  }

  public void cadastrarClienteJuridico(ClienteJuridico c) throws FileNotFoundException, IOException {

    Persistencia.getInstance().getGravaGerenciador().getClientesJuridico().add(c);
    Persistencia.getInstance().gravarDados();
  }
  
  public void cancelarCadastroClienteFisico(ClienteFisico c) throws FileNotFoundException, IOException{
      Persistencia.getInstance().getGravaGerenciador().getClientesfisico().remove(c);
      Persistencia.getInstance().gravarDados();
  }
  
  public void cancelarCadastroClienteJuridico(ClienteJuridico c) throws FileNotFoundException, IOException{
      Persistencia.getInstance().getGravaGerenciador().getClientesJuridico().remove(c);
      Persistencia.getInstance().gravarDados();
  }

  public void cadastrarClienteVipPessoaFisica(String cpf) throws FileNotFoundException, IOException {

    for (ClienteFisico cc : Persistencia.getInstance().getGravaGerenciador().getClientesfisico()) { // pesquisa se ja existe algum cpf cadastrado, se nao ele add no sistema
      if (cc.getCpf().equals(cpf)) {
        Persistencia.getInstance().getGravaGerenciador().getClientesvips().add(cc);

      } else {
        cadastrarClienteFisico(cc);
      }
    Persistencia.getInstance().gravarDados();
    }
  }

  public void cadastroClienteVipPessoaJuridica(String cnpj) throws FileNotFoundException, IOException {
    for (ClienteJuridico cc : Persistencia.getInstance().getGravaGerenciador().getClientesJuridico()) { // pesquisa se ja existe algum cpf cadastrado, se nao ele add no sistema
      if (cc.getCnpj().equals(cnpj)) {
        Persistencia.getInstance().getGravaGerenciador().getClientesvips().add(cc);
        

      } else {
        cadastrarClienteJuridico(cc);
      }
Persistencia.getInstance().gravarDados();
    }

  }

  public void cancelarCadastroClienteVipPessoaFisica(String nome, String cpf) throws FileNotFoundException, IOException {

    for (Cliente c : Persistencia.getInstance().getGravaGerenciador().getClientesvips()) {
      if (c.getNome().equals(nome) && (c.getCpf().equals(cpf))) {
        Persistencia.getInstance().getGravaGerenciador().getClientesvips().remove(c);
        Persistencia.getInstance().gravarDados();
      }
  
    }



  }

  public void cancelarCadastroClienteVipPessoaJuridica(String nome, String tel) throws FileNotFoundException, IOException {

    for (Cliente c : Persistencia.getInstance().getGravaGerenciador().getClientesvips()) {
      if (c.getNome().equals(nome) && (c.getTel().equals(tel))) {
        Persistencia.getInstance().getGravaGerenciador().getClientesvips().remove(c);
        Persistencia.getInstance().gravarDados();
      }
      
    }

  }

  public Cliente pesquisarClienteFisico(String cpf){
            for(ClienteFisico ve: Persistencia.getInstance().getGravaGerenciador().getClientesfisico()){
                    if(ve.getCpf().equals(cpf))
                        return ve;
            }
            return null;
}
  
  public Cliente pesquisarClienteFisicoVip(String cpf){
            for(Cliente ve: Persistencia.getInstance().getGravaGerenciador().getClientesvips()){
                    if(ve.getCpf().equals(cpf))
                        return ve;
            }
            return null;
  }
  
  public Cliente pesquisarClienteJuridico(String cpf){
            for(Cliente ve: Persistencia.getInstance().getGravaGerenciador().getClientesJuridico()){
                    if(ve.getCpf().equals(cpf))
                        return ve;
            }
            return null;
}
  
  public Cliente pesquisarClienteJuridicoVip(String cpf){
            for(Cliente ve: Persistencia.getInstance().getGravaGerenciador().getClientesvips()){
                    if(ve.getCpf().equals(cpf))
                        return ve;
            }
            return null;
  }
  
  
  public float pagamentoClienteComum(String placa, float tempoDoveiculo) {


    for (Veiculo veiculo : Persistencia.getInstance().getGravaGerenciador().getVeiculos()) {
      if (veiculo.getPlaca().equals(placa)) {
        if (tempoDoveiculo <= 3) {
          valor = valor + 2;
        }
        if ((tempoDoveiculo > 3) && (tempoDoveiculo <= 5)) {
          valor = valor + 3;

        }

        if (tempoDoveiculo > 5) {
          valor = valor + 5;
        }
      }


    }
    return valor;
  }

  public float pagamentoClienteVip(String nome, float tempo) {
    GerenteVeiculo gerente = new GerenteVeiculo();

    for (Cliente c : Persistencia.getInstance().getGravaGerenciador().getClientesvips()) {

      if (c.getNome().equals(nome)) {

        for (Veiculo v : Persistencia.getInstance().getGravaGerenciador().getVeiculos()) {
          if (tempo <= 3) {
            valor = valor + 1;
          }
          if ((tempo > 3) && (tempo <= 5)) {
            valor = valor + 2;

          }

          if (tempo > 5) {
            valor = valor + 3;
          }
        }
      }

    }
    return valor;


  }
  
}
