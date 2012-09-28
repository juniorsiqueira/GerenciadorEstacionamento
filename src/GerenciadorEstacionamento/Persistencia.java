/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciadorEstacionamento;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuniorSiqueira
 */
public class Persistencia {
  
  private static Persistencia persistencia;
  private GravaGerenciador GravaGerenciador ;
    
   private Persistencia() {
  }
    public static Persistencia getInstance(){
    if (persistencia == null){
      persistencia = new Persistencia();
    } else {
      return persistencia;
    }
    return persistencia;
  }
  
  public static void reset() {
    persistencia = null;
  }
    public void gravarDados() throws FileNotFoundException, IOException {
      
        ObjectOutputStream out = null;
      try{
        out = new ObjectOutputStream(new FileOutputStream("arquivo.bin"));
        out.writeObject(GravaGerenciador);
        out.close();
      }
        catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    
    }

    public void recuperarDados() throws FileNotFoundException, IOException {
        ObjectInputStream in = null;
        //GravaGerenciador x = new GravaGerenciador();
        try {
            in = new ObjectInputStream(new FileInputStream("arquivo.bin"));
            GravaGerenciador = (GravaGerenciador) in.readObject();
            
        } catch (Exception e) {
       GravaGerenciador = new GravaGerenciador();    
        } finally {
            if (in != null) {
                    in.close();
            }
        }
    }
    
  public GravaGerenciador getGravaGerenciador() {
    return GravaGerenciador;
  }

  public void setGravaGerenciador(GravaGerenciador GravaGerenciador) {
    this.GravaGerenciador = GravaGerenciador;
  }

}