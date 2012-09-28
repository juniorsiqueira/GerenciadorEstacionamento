package GerenciadorEstacionamento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class GerenteFuncionario {

//GravaGerenciador p = new GravaGerenciador();

  public void CadastrarFuncionario(Funcionario f) throws funcionarioExistenteException, FileNotFoundException, IOException, VeiculoExistenteException {
    if (Persistencia.getInstance().getGravaGerenciador().getVeiculos().contains(f.cpf)) {
      throw new VeiculoExistenteException("funcionario Cadastrado");
    }
    else if (Persistencia.getInstance().getGravaGerenciador().getVeiculos().contains(" ")) {
        throw new VeiculoExistenteException("Insira o CPF");
    }else{
    Persistencia.getInstance().getGravaGerenciador().getFuncionarios().add(f);
  Persistencia.getInstance().gravarDados();
}
  }
public Funcionario pesquisarFuncionario(String cpf){
            for(Funcionario ve: Persistencia.getInstance().getGravaGerenciador().getFuncionarios()){
                    if(ve.getCpf().equals(cpf))
                        return ve;
            }
            return null;
}
  public void DemitirFuncionario(String cpf) throws FileNotFoundException, IOException {
    for (Funcionario ve : Persistencia.getInstance().getGravaGerenciador().getFuncionarios()) {
      if (ve.getCpf().equals(cpf)) {
        Persistencia.getInstance().getGravaGerenciador().getFuncionarios().remove(ve);
        Persistencia.getInstance().gravarDados();
        return;
      }
    }
  }

  public Funcionario CriarConta(Funcionario fun) throws FileNotFoundException, IOException {

    if (fun.getCpf() == null) {
      fun.nome = "marinalva";
      fun.cpf = "8989";
      fun.login = "mariana";
      fun.senha = "123";
      Persistencia.getInstance().getGravaGerenciador().getFuncionarios().add(fun);
      Persistencia.getInstance().gravarDados();

    }

    return fun;
  }

  public boolean Logar(String login, String senha) {

    for (Funcionario u : Persistencia.getInstance().getGravaGerenciador().getFuncionarios()) {
      if (login.equals(u.getLogin()) && senha.equals(u.getSenha())) {
        return true;
      } else {
        return false;
      }
    }
    return false;
  }
}
