/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciadorEstacionamento;

/**
 *
 * @author thiagomello
 */
public class ClienteFisico extends Cliente{
	
    
    public ClienteFisico(String nome, String cpf, String tel){
        super(nome, cpf, tel);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ClienteFisico() {
    }


}  
