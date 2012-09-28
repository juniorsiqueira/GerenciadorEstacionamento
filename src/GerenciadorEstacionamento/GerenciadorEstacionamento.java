package GerenciadorEstacionamento;

import java.io.IOException;
import java.util.LinkedList;
import javax.sound.midi.SysexMessage;

public class GerenciadorEstacionamento {

  public static void main(String[] args) throws IOException, ClassNotFoundException, funcionarioExistenteException {
Fachada f = new Fachada ();
    ClienteFisico maria = new ClienteFisico("maria", "0000", "12345");
    f.cadastrarClienteFisico(maria);
    System.out.println (maria);
    System.out.println (f.pesquisarClienteFisico("0000"));
    
  }
}
