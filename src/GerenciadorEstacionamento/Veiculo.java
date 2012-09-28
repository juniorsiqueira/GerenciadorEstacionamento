package GerenciadorEstacionamento;

import java.io.Serializable;

public class Veiculo implements Serializable {

  private String placa;
  private String modelo;
  private String cor;
    private boolean lavado;
	private boolean polido;
	private boolean troca_oleo;
    
  public Veiculo(String placa, String modelo, String cor) {
    this.placa = placa;
    this.modelo = modelo;
    this.cor = cor;
  }

    public Veiculo() {
    }
  
  

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public boolean isLavado() {
    return lavado;
  }

  public void setLavado(boolean lavado) {
    this.lavado = lavado;
  }

  public boolean isPolido() {
    return polido;
  }

  public void setPolido(boolean polido) {
    this.polido = polido;
  }

  public boolean isTroca_oleo() {
    return troca_oleo;
  }

  public void setTroca_oleo(boolean troca_oleo) {
    this.troca_oleo = troca_oleo;
  }

  @Override
  public String toString() {
    return "Veiculo{" + "placa=" + placa + ", modelo=" + modelo + ", cor=" + cor + ", lavado=" + lavado + ", polido=" + polido + ", troca_oleo=" + troca_oleo + '}';
  }

  
}
