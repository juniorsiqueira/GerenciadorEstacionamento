/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciadorEstacionamento;

/**
 *
 * @author thiagomello
 */
public class Cliente extends Pessoa{
   
	public Cliente(String nome,String end, String tel ){
		this.nome = nome;
		this.end = end;
		this.telefone = telefone;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return telefone;
	}

	public void setTel(String tel) {
		this.telefone = tel;
	}

	public String getEnd() {
		return end;
	}
	
        public void setEnd(String end){
            this.end=end;
        }

    public Cliente() {
    }
        
        
	
}
