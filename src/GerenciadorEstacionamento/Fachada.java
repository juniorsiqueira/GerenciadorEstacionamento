/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciadorEstacionamento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author JuniorSiqueira
 */
public class Fachada {
    private GerenteVeiculo gerenteVeiculo;
	private GerenteCliente gerenteCliente;
	private GerenteFuncionario gerenteFuncionario;
	
	
	public Fachada() throws IOException, ClassNotFoundException{
		this.gerenteVeiculo = new GerenteVeiculo();
		this.gerenteCliente = new GerenteCliente();
		this.gerenteFuncionario = new GerenteFuncionario();
        Persistencia.getInstance().recuperarDados();
	}


  public void cancelarCadastroClienteVipPessoaJuridica(String nome, String tel) throws IOException {
    gerenteCliente.cancelarCadastroClienteVipPessoaJuridica(nome, tel);
  }

  public void cancelarCadastroClienteVipPessoaFisica(String nome, String tel) throws IOException {
    gerenteCliente.cancelarCadastroClienteVipPessoaFisica(nome, tel);
  }
  
  public void cancelarCadastroClienteComum(ClienteFisico cpf) throws IOException{
      gerenteCliente.cancelarCadastroClienteFisico(cpf);
  }
  
  
  public void cancelarCadastroClienteJuridicoComum(ClienteJuridico cpf) throws IOException{
      gerenteCliente.cancelarCadastroClienteJuridico(cpf);
  }
  
  
  public void cadastroClienteVipPessoaJuridica(String cnpj) throws IOException {
    gerenteCliente.cadastroClienteVipPessoaJuridica(cnpj);
  }

  public void cadastrarClienteVipPessoaFisica(String cpf) throws IOException {
    gerenteCliente.cadastrarClienteVipPessoaFisica(cpf);
  }

  public void cadastrarClienteJuridico(ClienteJuridico c) throws IOException {
    gerenteCliente.cadastrarClienteJuridico(c);
  }

  public void cadastrarClienteFisico(ClienteFisico c) throws IOException {
    gerenteCliente.cadastrarClienteFisico(c);
  }

  public Cliente pesquisarClienteFisico (String cpf){
    return gerenteCliente.pesquisarClienteFisico(cpf);
  }
  
  public Cliente pesquisarClienteFisicoVip (String cpf){
    return gerenteCliente.pesquisarClienteFisicoVip(cpf);
  }
  
  
  public Cliente pesquisarClienteJuridicoVip (String cpf){
    return gerenteCliente.pesquisarClienteJuridicoVip(cpf);
  }
  
  
  
  public Cliente pesquisarClienteJuridico (String cpf){
    return gerenteCliente.pesquisarClienteJuridico(cpf);
  } 
          
  public Funcionario pesquisarFuncionario(String cpf) {
    return gerenteFuncionario.pesquisarFuncionario(cpf);
  }

  public boolean Logar(String login, String senha) {
    return gerenteFuncionario.Logar(login, senha);
  }

  public void DemitirFuncionario(String cpf) throws FileNotFoundException, IOException {
    gerenteFuncionario.DemitirFuncionario(cpf);
  }

  public Funcionario CriarConta(Funcionario fun) throws FileNotFoundException, IOException {
    return gerenteFuncionario.CriarConta(fun);
  }

  public void CadastrarFuncionario(Funcionario f) throws funcionarioExistenteException, FileNotFoundException, IOException, VeiculoExistenteException {
    gerenteFuncionario.CadastrarFuncionario(f);
  }

  public void registrarEntradaVeiculo(Veiculo v) throws IOException {
    gerenteVeiculo.registrarEntradaVeiculo(v);
  }

  public Veiculo pesquisarVeiculo(String placa) {
    return gerenteVeiculo.pesquisarVeiculo(placa);
  }

  public Veiculo liberarVeiculo(String placa) throws IOException {
    return gerenteVeiculo.liberarVeiculo(placa);
  }

  public List<Veiculo> getVeiculosNoEstacionamento() throws IOException {
    return gerenteVeiculo.getVeiculosNoEstacionamento();
  }

  public void excluirVeiculo(String placa) throws IOException {
    gerenteVeiculo.excluirVeiculo(placa);
  }

  public void cadastrarVeiculo(Veiculo veiculo) throws VeiculoExistenteException, IOException {
    gerenteVeiculo.cadastrarVeiculo(veiculo);
  }

  void atualizarVeiculo(Veiculo v) {
    gerenteVeiculo.atualizarVeiculo(v);
  }
  public void lavarCarro(Veiculo v){
    	gerenteVeiculo.lavarCarro(v);
    }
    public void polirCarro(Veiculo v){
    	gerenteVeiculo.polirCarro(v);
    }
    public void trocarOleoCarro(Veiculo v){
    	gerenteVeiculo.trocarOleoCarro(v);
    }
    public float valorSevico(Veiculo v){
    	return gerenteVeiculo.valorSevico(v);
    }
    public List<Veiculo> carroNaoLavados(){
    	return gerenteVeiculo.Naolavados();
    }
	
	public float efetuarPagamentoClienteComum(String placa, float tempo){
		return gerenteCliente.pagamentoClienteComum(placa, tempo);
	}
  
	public float efetuarPagamentoClienteVip(String nome, float tempo){
		return gerenteCliente.pagamentoClienteVip(nome, tempo);
	}

   
  }
