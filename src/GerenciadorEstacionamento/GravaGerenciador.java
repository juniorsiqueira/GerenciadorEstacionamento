/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciadorEstacionamento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JuniorSiqueira
 */
public class GravaGerenciador implements Serializable {

  private List<Cliente> clientesvips = new LinkedList<Cliente>();
  private List<Funcionario> funcionarios = new LinkedList<Funcionario>();
  private List<Veiculo> veiculos = new LinkedList<Veiculo>();
  private List<Veiculo> Vagas = new ArrayList<Veiculo>();
  private List<ClienteFisico> clientesfisico = new LinkedList<ClienteFisico>();
  private List<ClienteJuridico> clientesJuridico = new LinkedList<ClienteJuridico>();
  private List<Veiculo> VagasOcupadas = new ArrayList<Veiculo>();
  private List<Veiculo> esperaLavar = new ArrayList<Veiculo>();

  public List<Veiculo> getVagas() {
    return Vagas;
  }

  public void setVagas(List<Veiculo> Vagas) {
    this.Vagas = Vagas;
  }

  public List<Veiculo> getVagasOcupadas() {
    return VagasOcupadas;
  }

  public void setVagasOcupadas(List<Veiculo> VagasOcupadas) {
    this.VagasOcupadas = VagasOcupadas;
  }

  public List<ClienteJuridico> getClientesJuridico() {
    return clientesJuridico;
  }

  public void setClientesJuridico(List<ClienteJuridico> clientesJuridico) {
    this.clientesJuridico = clientesJuridico;
  }

  public List<ClienteFisico> getClientesfisico() {
    return clientesfisico;
  }

  public void setClientesfisico(List<ClienteFisico> clientesfisico) {
    this.clientesfisico = clientesfisico;
  }

  public List<Cliente> getClientesvips() {
    return clientesvips;
  }

  public void setClientesvips(List<Cliente> clientesvips) {
    this.clientesvips = clientesvips;
  }

  public List<Funcionario> getFuncionarios() {
    return funcionarios;
  }

  public void setFuncionarios(List<Funcionario> funcionarios) {
    this.funcionarios = funcionarios;
  }

  public List<Veiculo> getVeiculos() {
    return veiculos;
  }

  public void setVeiculos(List<Veiculo> veiculos) {
    this.veiculos = veiculos;
  }

  public List<Veiculo> getEsperaLavar() {
    return esperaLavar;
  }

  public void setEsperaLavar(List<Veiculo> esperaLavar) {
    this.esperaLavar = esperaLavar;
  }

}
