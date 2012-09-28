package GerenciadorEstacionamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class GerenteVeiculo {

 // GravaGerenciador p = new GravaGerenciador();
  
  public void cadastrarVeiculo(Veiculo veiculo) throws VeiculoExistenteException, IOException {
    //if (Persistencia.getInstance().getGravaGerenciador().getVeiculos().contains(veiculo)) {
     // throw new VeiculoExistenteException("veiculo ja cadastrado!");
    //}
    Persistencia.getInstance().getGravaGerenciador().getVeiculos().add(veiculo);
    Persistencia.getInstance().gravarDados();
  }

  public Veiculo pesquisarVeiculo(String placa) {
    for (Veiculo ve : Persistencia.getInstance().getGravaGerenciador().getVeiculos()) {
      if (ve.getPlaca().equals(placa)) {
        return ve;
      }
    }
 return null;
  }

   public void excluirVeiculo(String placa) throws IOException {
    for (Veiculo ve : Persistencia.getInstance().getGravaGerenciador().getVeiculos()) {
      if (ve.getPlaca().equals(placa)) {
        Persistencia.getInstance().getGravaGerenciador().getVeiculos().remove(ve);
        Persistencia.getInstance().gravarDados();

      }
      return;
    }

  }

  public List<Veiculo> getVeiculosNoEstacionamento() throws IOException {

    for (Veiculo ve : Persistencia.getInstance().getGravaGerenciador().getVeiculos()) {
      if (Persistencia.getInstance().getGravaGerenciador().getVagas().contains(ve));
      Persistencia.getInstance().getGravaGerenciador().getVagasOcupadas().add(ve);
      Persistencia.getInstance().gravarDados();

    }
    return Persistencia.getInstance().getGravaGerenciador().getVagasOcupadas();
  }

  public Veiculo liberarVeiculo(String placa) throws IOException {
    for (Veiculo v : Persistencia.getInstance().getGravaGerenciador().getVeiculos()) {
      if (v.getPlaca().equals(placa)) {
        Persistencia.getInstance().getGravaGerenciador().getVagas().remove(v);
        Persistencia.getInstance().gravarDados();
        return v;

      }
    }
    return null;
  }

  public void registrarEntradaVeiculo(Veiculo v) throws IOException {
    for (Veiculo veiculo : Persistencia.getInstance().getGravaGerenciador().getVeiculos()) {
      if (v.equals(veiculo)) {
        Persistencia.getInstance().getGravaGerenciador().getVagasOcupadas().add(v);
        Persistencia.getInstance().gravarDados();
        break;
      }

    }
  }

  void atualizarVeiculo(Veiculo v) {
    for (Veiculo v2 : Persistencia.getInstance().getGravaGerenciador().getVeiculos()) {
      if (v2.equals(v)) {
        v2.setPlaca(v.getPlaca());
        v2.setModelo(v.getModelo());
        v2.setCor(v.getCor());

      }
    }
  }
      public void lavarCarro(Veiculo  veiculo){
		
		veiculo.setLavado(true);
	}
	
	public void polirCarro(Veiculo veiculo){
		
		veiculo.setPolido(true);
		
	}
	public void trocarOleoCarro(Veiculo veiculo){
		
		veiculo.setTroca_oleo(true);
		
	}
	public List<Veiculo> Naolavados(){
		
		for(Veiculo v: Persistencia.getInstance().getGravaGerenciador().getVeiculos()){
			if(v.isLavado() == false){
				Persistencia.getInstance().getGravaGerenciador().getEsperaLavar().add(v);
			}
		}
		return Persistencia.getInstance().getGravaGerenciador().getEsperaLavar();
	}
	public float valorSevico(Veiculo veiculo){
		float valor = 0;
		
		if(veiculo.isLavado() == true){
			valor += 10;
		}
		if(veiculo.isPolido() == true){
			valor += 20;
		}
		if(veiculo.isTroca_oleo() == true){
			valor += 50;
		}
		System.out.println(valor);
		return valor;
			
	}
    }