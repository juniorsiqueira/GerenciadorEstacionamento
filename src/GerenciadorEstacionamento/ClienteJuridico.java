/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciadorEstacionamento;

/**
 *
 * @author thiagomello
 */
public class ClienteJuridico extends Cliente{
    
    
    public String cnpj;

    
  public ClienteJuridico(String nome,String cnpj, String tel){
      super(  cnpj, nome, tel);
    
}

    public ClienteJuridico() {
    }

  
  
  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }
  
    }  
