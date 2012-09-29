
import GerenciadorEstacionamento.*;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author thiagomello
 */
public class FachadaTeste {
  
  @Before
  
  public void apagar() {
    File file = new File("arquivo.bin");    
     if (file.exists()) {
       file.delete();
    }
  }

    @Test
    public void pesquisarVeiculoTest() throws VeiculoExistenteException, IOException, ClassNotFoundException {

      
        Fachada ff = new Fachada();
        Fachada fa = new Fachada();
        Assert.assertNull(fa.pesquisarVeiculo("MOH-2121"));
        Veiculo caminhao = new Veiculo();
        caminhao.setPlaca("MOH");
        caminhao.setCor("Azul");
        caminhao.setModelo("2012");
        
        Veiculo fusca = new Veiculo();
        fusca.setPlaca("CDE");
        fusca.setModelo("2012");
        fusca.setCor("Azul");
        
        Veiculo fusca2 = new Veiculo();
        fusca2.setPlaca("CDE");
        fusca2.setModelo("2012");
        fusca2.setCor("Azul");
        fa.cadastrarVeiculo(caminhao);
        fa.cadastrarVeiculo(fusca);
        fa.cadastrarVeiculo(fusca2);
        
        Assert.assertTrue("1963", fusca.getModelo().equals(fusca2.getModelo()));
        Assert.assertFalse("ABC", fusca.equals(fusca2));
        Assert.assertEquals(ff.pesquisarVeiculo(fusca.getPlaca()),ff.pesquisarVeiculo(fusca2.getPlaca()));
        Assert.assertNotNull(fa.getVeiculosNoEstacionamento());
        Assert.assertEquals(fa.pesquisarVeiculo(fusca.getPlaca()), fusca);
        Assert.assertNotNull(fa.pesquisarVeiculo(caminhao.getPlaca()));
        Assert.assertNotSame(fa.pesquisarVeiculo(caminhao.getPlaca()),
                fa.pesquisarVeiculo(null));
        Assert.assertNotSame(fa.pesquisarVeiculo(fusca.getPlaca()),
                fa.pesquisarVeiculo(caminhao.getPlaca()));
        Assert.assertSame(fa.pesquisarVeiculo(fusca.getPlaca()), fa.pesquisarVeiculo(fusca2.getPlaca()));
     
        Fachada f2 = new Fachada();
        Assert.assertNotNull(f2.getVeiculosNoEstacionamento());
        Assert.assertEquals(f2.pesquisarVeiculo(fusca.getPlaca()),f2.pesquisarVeiculo(fusca2.getPlaca()));
    }

    @Test
    public void cadastrarVeiculoTest() throws VeiculoExistenteException, IOException, ClassNotFoundException {

        Fachada fachada = new Fachada();
        
        Assert.assertNull(fachada.pesquisarVeiculo("MOH"));

        Veiculo fusca = new Veiculo();
        fusca.setPlaca("MOH");
        fusca.setModelo("2012");
        fusca.setCor("Azul");
        
        fachada.cadastrarVeiculo(fusca);
        Veiculo monza = new Veiculo("NJK", "2011", "Azul");
        monza.setPlaca("MOH");
        
        fachada.cadastrarVeiculo(monza);
        Assert.assertEquals(fachada.pesquisarVeiculo(fusca.getPlaca()).getPlaca(),
                fachada.pesquisarVeiculo(monza.getPlaca()).getPlaca());
        Assert.assertSame(fusca.getCor(), monza.getCor());
        Assert.assertTrue(fachada.pesquisarVeiculo(fusca.getPlaca()).equals(fachada.pesquisarVeiculo(monza.getPlaca())));
        fachada.cadastrarVeiculo(monza);
        Assert.assertNotNull(fachada.pesquisarVeiculo(fusca.getPlaca()).getPlaca(),
          fachada.pesquisarVeiculo(monza.getPlaca()).getPlaca());
         
        Fachada f2 = new Fachada();
        Veiculo v = f2.pesquisarVeiculo(fusca.getPlaca());
        Veiculo v2 = f2.pesquisarVeiculo(monza.getPlaca()); 
        Assert.assertEquals(v.getPlaca(), v2.getPlaca());
        Assert.assertTrue(f2.pesquisarVeiculo(fusca.getPlaca()).equals(f2.pesquisarVeiculo(monza.getPlaca())));
        
    }

     @Test
    public void registrarEntradaVeiculoTest() throws
VeiculoExistenteException, IOException, ClassNotFoundException {

        Fachada f = new Fachada();
        Veiculo carro = new Veiculo();
        carro.setPlaca("MOH");
        carro.setModelo("2012");
        carro.setCor("Azul");

        f.cadastrarVeiculo(carro);
        f.registrarEntradaVeiculo(carro);
        Veiculo cadastrado = f.pesquisarVeiculo("MOH");
        Assert.assertNotNull(cadastrado);
        Assert.assertEquals("MOH", cadastrado.getPlaca());
        Assert.assertEquals("2012", cadastrado.getModelo());
        Assert.assertEquals("Azul", cadastrado.getCor());
        carro.setPlaca(null);
        Assert.assertNull(carro.getPlaca());


        Fachada f2 = new Fachada();
        Veiculo cadastrado2 = f2.pesquisarVeiculo("MOH");

        Assert.assertNotNull(cadastrado2);
        Assert.assertEquals("MOH", cadastrado2.getPlaca());
        Assert.assertEquals("2012", cadastrado2.getModelo());
        Assert.assertEquals("Azul", cadastrado2.getCor());
    }

   @Test
    public void liberarVeiculoTest() throws VeiculoExistenteException,
IOException, ClassNotFoundException {

        Fachada f = new Fachada();
        Veiculo fusca = new Veiculo("ABC", "1963", "Azul");
        f.cadastrarVeiculo(fusca);
        f.registrarEntradaVeiculo(fusca);
        f.liberarVeiculo(fusca.getPlaca());
        Assert.assertNotNull(f.pesquisarVeiculo(fusca.getPlaca()));
        Assert.assertEquals(fusca, f.pesquisarVeiculo(fusca.getPlaca()));


        Fachada f2 = new Fachada();

        Assert.assertNotNull(f2.pesquisarVeiculo(fusca.getPlaca()));
        Assert.assertNotSame(fusca,
f2.pesquisarVeiculo(fusca.getPlaca()));   
        // Não sera igual, pois a
//persistencia guarda um Objeto Veiculo e esse método compara um Objeto
//com uma String (GetPlaca) com um Veiculo("ABC","1963","Azul")

    }

    @Test
    public void excluirVeiculoTest() throws VeiculoExistenteException, IOException, ClassNotFoundException {

        Fachada f = new Fachada();
        Veiculo L200 = new Veiculo("MOH", "2012", "Azul");
        GerenteVeiculo ger = new GerenteVeiculo();
        ger.cadastrarVeiculo(L200);
        Veiculo frontier = new Veiculo("PHP", "2000", "rosa");
        ger.cadastrarVeiculo(frontier);
        Assert.assertNotNull(L200);
        f.excluirVeiculo(L200.getPlaca());
        Veiculo fusca = new Veiculo("HTM", "1995", "amarelo");
        f.cadastrarVeiculo(fusca);
        Assert.assertNull(f.pesquisarVeiculo(L200.getPlaca()));
        Assert.assertEquals(null, f.pesquisarVeiculo(L200.getPlaca()));
        Assert.assertNotSame(f.pesquisarVeiculo(L200.getModelo()), L200.getModelo());
        f.excluirVeiculo(frontier.getPlaca());
        Assert.assertFalse(frontier.getPlaca().equals(f.pesquisarVeiculo(L200.getPlaca())));
        Assert.assertNull(f.pesquisarVeiculo(frontier.getPlaca()));
        Assert.assertNull((f.pesquisarVeiculo(L200.getPlaca())));
        
        Fachada f2 = new Fachada();
        Assert.assertNull(f.pesquisarVeiculo(null));
        
    }

    @Test
    public void efetuarPagamentoClienteComum() throws IOException, ClassNotFoundException, VeiculoExistenteException {
        Fachada fachada = new Fachada();
        Veiculo veiculo = new Veiculo("OKM", "2012", "CINZA");
        fachada.cadastrarVeiculo(veiculo);
        Assert.assertNotNull(veiculo);
        Assert.assertNotNull(veiculo.getPlaca());
        Assert.assertNotNull(veiculo.getModelo());
        Assert.assertNotNull(veiculo.getCor());
        Assert.assertEquals("OKM", fachada.pesquisarVeiculo("OKM").getPlaca());
        Assert.assertNotSame(fachada.efetuarPagamentoClienteComum(veiculo.getPlaca(), 2), fachada.efetuarPagamentoClienteComum(veiculo.getPlaca(), 4));
        Assert.assertNotSame(0, fachada.efetuarPagamentoClienteComum(veiculo.getPlaca(), 4));
        Fachada f2 = new Fachada();
        Assert.assertEquals("OKM", f2.pesquisarVeiculo("OKM").getPlaca());
        Assert.assertNotSame(f2.efetuarPagamentoClienteComum(veiculo.getPlaca(), 2), f2.efetuarPagamentoClienteComum(veiculo.getPlaca(), 4));

    }

    @Test
    public void efetuarPagamentoClienteVip() throws IOException, ClassNotFoundException, VeiculoExistenteException {
        Fachada fachada = new Fachada();
        Veiculo veiculo = new Veiculo("IJK", "2011", "PRETO");

        Cliente cliente = new Cliente();

        cliente.setNome("Thiago");
        cliente.setTel("bessa");
        cliente.setEnd("0000-0000");

        fachada.cadastrarVeiculo(veiculo);
        fachada.cadastrarClienteVipPessoaFisica(cliente.getCpf());

        Assert.assertNotNull(veiculo);
        Assert.assertNotNull(veiculo.getPlaca());
        Assert.assertNotNull(veiculo.getModelo());
        Assert.assertNotNull(veiculo.getCor());

        Assert.assertNotNull(cliente);
        Assert.assertNotNull(cliente.getCpf());
        Assert.assertNotNull(cliente.getEnd());
        Assert.assertNotNull(cliente.getNome());

        Assert.assertEquals("IJK", fachada.pesquisarVeiculo("IJK").getPlaca());
        Assert.assertNotSame(fachada.efetuarPagamentoClienteVip(cliente.getNome(), 2), fachada.efetuarPagamentoClienteVip(cliente.getNome(), 7));
        Assert.assertNotSame(0, fachada.efetuarPagamentoClienteVip(cliente.getNome(), 4));
        Fachada f2 = new Fachada();
        Assert.assertNotNull(f2.pesquisarVeiculo("IJK"));
        Assert.assertEquals("IJK", f2.pesquisarVeiculo("IJK").getPlaca());
    
    }

    @Test
    public void criarContaTest() throws funcionarioExistenteException, IOException, ClassNotFoundException, VeiculoExistenteException {

        Fachada f = new Fachada();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Thiago");
        funcionario.setCpf("06546505436");
        funcionario.setEndereco("JPA");
        funcionario.setTelefone("234");

        f.CadastrarFuncionario(funcionario);
        Assert.assertNotNull(funcionario);

        Funcionario funcionario2 = new Funcionario();
        funcionario2.setNome("Junior");
        funcionario2.setCpf("22222222222");
        funcionario2.setEndereco("CG");
        funcionario2.setTelefone("@Bebezao");

        f.CadastrarFuncionario(funcionario2);
        Assert.assertNotNull(funcionario2);

        Assert.assertNotNull(f.pesquisarFuncionario(funcionario.getCpf()));
        Assert.assertEquals("Thiago", funcionario.getNome());
        Assert.assertNotNull(f.CriarConta(funcionario));
        Assert.assertNotSame(f.CriarConta(funcionario2), f.CriarConta(funcionario));
        Assert.assertFalse(f.pesquisarFuncionario(funcionario.getCpf()).equals(f.pesquisarFuncionario(funcionario2.getCpf())));
        Assert.assertSame(funcionario2, f.CriarConta(funcionario2));
        Assert.assertNotSame(" ", f.pesquisarFuncionario(funcionario2.getCpf()));
        
        Fachada f2 = new Fachada();
        Assert.assertNotNull(f2.pesquisarFuncionario(funcionario.getCpf()));
        Assert.assertEquals(f.pesquisarFuncionario(funcionario.getCpf()), f2.pesquisarFuncionario(funcionario.getCpf()));
        
    }

    @Test
    public void logarTest() throws funcionarioExistenteException, IOException, ClassNotFoundException, VeiculoExistenteException {

        Fachada f = new Fachada();
        GerenteFuncionario g = new GerenteFuncionario();


        Funcionario thiago = new Funcionario();

        thiago.setNome("Thiago");
        thiago.setCpf("06546505436");
        thiago.setEndereco("JPA");
        thiago.setTelefone("234");
        thiago.setLogin("@ThiagoMello");
        thiago.setSenha("APS");

        Funcionario junior = new Funcionario();
        junior.setNome("junior");
        junior.setCpf("22222222222");
        junior.setLogin("@bebezao");
        junior.setSenha("APS");

        f.CadastrarFuncionario(thiago);
        f.CadastrarFuncionario(junior);
        Assert.assertNotNull(junior);
        Assert.assertNotNull(thiago);

        Assert.assertTrue(f.Logar(thiago.getLogin(), thiago.getSenha()));
        Assert.assertNotNull(f.Logar(thiago.getLogin(), thiago.getSenha()));
        Assert.assertFalse(f.Logar(thiago.getLogin(), "APX"));
       
        Fachada f2 = new Fachada();
        Assert.assertNotNull(f2.Logar(thiago.getLogin(), junior.getLogin()));
        Assert.assertFalse(f2.Logar(thiago.getLogin(), "Analise Projeto de Sistemas"));
    }

    @Test
    public void getVeiculosNoEstacionamentoTest() throws IOException, ClassNotFoundException, VeiculoExistenteException {
      
        
       Fachada f = new Fachada();
        List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        Veiculo carro = new Veiculo();
        carro.setPlaca("MOH");
        carro.setModelo("2012");
        carro.setCor("Azul");
        f.cadastrarVeiculo(carro);
        Veiculo carroPreto = new Veiculo("MOH", "2012", "Preto");
        Veiculo carro1 = carro;
        carro1.setPlaca("MOH");
        carro1.setModelo("2012");
        carro1.setCor("Azul");
        f.cadastrarVeiculo(carroPreto);
        GerenteVeiculo g = new GerenteVeiculo();
        listaVeiculos.add(carro);
        listaVeiculos.add(carroPreto);
        listaVeiculos.add(carro1);
        Assert.assertEquals("MOH", carro.getPlaca());
        Assert.assertEquals("Azul", carro.getCor());
        Assert.assertEquals("2012", carro.getModelo());
        Assert.assertEquals(carro1, carro);
        Assert.assertEquals(carro.getModelo(), carroPreto.getModelo());
        Assert.assertSame(f.getVeiculosNoEstacionamento(), g.getVeiculosNoEstacionamento());
        Assert.assertSame(f.liberarVeiculo(carro.getPlaca()), g.liberarVeiculo(carro.getPlaca()));
        Assert.assertNotNull(f.getVeiculosNoEstacionamento());
        Assert.assertNotNull(g.getVeiculosNoEstacionamento());
        Assert.assertSame("Objetos Iguais", carro1, carro);
    }

    @Test
    public void cadastrarFuncionarioTest() throws funcionarioExistenteException, IOException, ClassNotFoundException, VeiculoExistenteException {

        Fachada f = new Fachada();
        Funcionario francisco = new Funcionario("Francisco", "01214781497", "JPA", "@123", "APS");
        Funcionario thiago = new Funcionario("Thiago", "0121497", "JPA", "123", "APS");
        f.CadastrarFuncionario(thiago);
        f.CadastrarFuncionario(francisco);
        Assert.assertNotNull(f.pesquisarFuncionario(francisco.getCpf()));
        Assert.assertFalse(f.pesquisarFuncionario(francisco.getCpf()).equals (f.pesquisarFuncionario(thiago.getCpf())));
        Assert.assertEquals(f.pesquisarFuncionario(francisco.getEndereco()), f.pesquisarFuncionario(thiago.getEndereco()));
        Assert.assertFalse("".equals(f.pesquisarFuncionario(francisco.getCpf())));
        f.DemitirFuncionario(thiago.getCpf());
        f.DemitirFuncionario(francisco.getCpf());
        Assert.assertNull(f.pesquisarFuncionario(thiago.getCpf()));
        Assert.assertNull(f.pesquisarFuncionario(francisco.getCpf()));
        
        
         }

    @Test
    public void demitirFuncionarioTest() throws funcionarioExistenteException, IOException, ClassNotFoundException, VeiculoExistenteException {

        Fachada fachada = new Fachada();
        Funcionario silvia = new Funcionario("silvia", "01214781497", "JPA", "@SilviaAzevedo", "APS");
        fachada.CadastrarFuncionario(silvia);
        Assert.assertNotNull(silvia);
        fachada.pesquisarFuncionario(silvia.getCpf());
        fachada.DemitirFuncionario(silvia.getCpf());
        Assert.assertNull(fachada.pesquisarFuncionario(silvia.getCpf()));
        Assert.assertEquals(fachada.pesquisarFuncionario(silvia.getCpf()), null);
        Funcionario Thiago = new Funcionario("Thiago", "06477688", "JPA", "@ThiagoMello", "APS");
        fachada.CadastrarFuncionario(Thiago);
        Assert.assertNotNull(fachada.pesquisarFuncionario(Thiago.getCpf()));
        Assert.assertFalse((fachada.pesquisarFuncionario(Thiago.getCpf()).equals(fachada.pesquisarFuncionario(silvia.getCpf()))));
        fachada.DemitirFuncionario(Thiago.getCpf());
        Assert.assertEquals(fachada.pesquisarFuncionario(silvia.getCpf()), fachada.pesquisarFuncionario(Thiago.getCpf()));
    }

    @Test
    public void cadastrarClienteTest() throws funcionarioExistenteException, IOException, ClassNotFoundException, VeiculoExistenteException {

        Fachada f = new Fachada();
        Assert.assertNull(f.pesquisarClienteFisico(null));
        Assert.assertNull(f.pesquisarClienteJuridico(null));
        
        ClienteFisico maria = new ClienteFisico("Maria", "12345", "34333333");
        ClienteFisico antonia = new ClienteFisico("Antonia", "54321", "34333333");
        
        ClienteJuridico joao = new ClienteJuridico("joao", "08979250000127", "34391010");
        ClienteJuridico toinho = new ClienteJuridico("toinho", "01234456000827", "34391090");
        Funcionario maria2 = new Funcionario("maria", "01214781497", "JPA", "@Maria", "APS");
        f.CadastrarFuncionario(maria2);
        f.cadastrarClienteFisico(maria);
        f.cadastrarClienteFisico(antonia);
        f.cadastrarClienteJuridico(joao);
        f.cadastrarClienteJuridico(toinho);

        Assert.assertNotNull(maria);
        Assert.assertNotNull(antonia);
        Assert.assertNotNull(joao);
        Assert.assertNotNull(toinho);
        Assert.assertFalse(f.pesquisarClienteFisico(maria.getCpf()).equals(antonia.getCpf()));
        Assert.assertFalse(f.pesquisarClienteFisico(joao.getCpf()).equals(antonia.getCpf()));
        Assert.assertFalse(f.pesquisarClienteJuridico(toinho.getCpf()).equals(f.pesquisarClienteFisico((antonia.getCpf()))));
        Assert.assertNotSame(f.pesquisarClienteFisico(maria.getCpf()), f.pesquisarFuncionario(maria2.getCpf()));
        Assert.assertNotSame(f.pesquisarClienteJuridico(joao.getCpf()), f.pesquisarFuncionario(maria2.getCpf()));
        Assert.assertNotSame(f.pesquisarClienteJuridico(toinho.getCpf()), f.pesquisarFuncionario(maria2.getCpf()));

        
        f.cancelarCadastroClienteVipPessoaFisica("Maria", "12345");
        f.cancelarCadastroClienteVipPessoaFisica("Antonia", "54321");
//    Assert.assertNull(f.pesquisarClienteFisico(maria.getCpf()));
//    Assert.assertNull(f.pesquisarClienteFisico(antonia.getCpf()));
//    Assert.assertEquals(f.pesquisarClienteFisico(maria.getCpf()), f.pesquisarClienteFisico(null));
//    Assert.assertEquals(f.pesquisarClienteFisico(maria.getCpf()), f.pesquisarClienteFisico(antonia.getCpf()));
    }

    @Test
    public void CancelarCadastroPessoaFisicaVip() throws IOException, ClassNotFoundException{
        
        Fachada fachadas = new Fachada();
        GerenteCliente gerente = new GerenteCliente();
        Assert.assertNull(fachadas.pesquisarClienteFisicoVip(null));
      
        
        ClienteFisico clientefisicoVip = new ClienteFisico();
        clientefisicoVip.setNome("Thiago");
        clientefisicoVip.setCpf("123");
        
        fachadas.cadastrarClienteVipPessoaFisica(clientefisicoVip.getCpf());
   
        Assert.assertNotNull(clientefisicoVip.getNome(),clientefisicoVip.getTel());
        fachadas.cancelarCadastroClienteVipPessoaFisica(clientefisicoVip.getCpf(),clientefisicoVip.getTel());
        Assert.assertNull(fachadas.pesquisarClienteFisicoVip(clientefisicoVip.getCpf()));
        Assert.assertEquals(null, fachadas.pesquisarClienteFisicoVip(clientefisicoVip.getCpf()));
        
    }
    
    @Test 
        public void CancelarCadastroPessoaFisicaComum() throws IOException, ClassNotFoundException{
         
        Fachada fachada = new Fachada();
       
        GerenteCliente gerente = new GerenteCliente();
        Assert.assertNull(fachada.pesquisarClienteFisicoVip(null));
      
        
        ClienteFisico clientefisico = new ClienteFisico();
        clientefisico.setNome("Thiago Mello");
        clientefisico.setCpf("7364728");
        
        fachada.cadastrarClienteFisico(clientefisico);
        Assert.assertNotNull(clientefisico.getNome(),clientefisico.getTel());
        fachada.cancelarCadastroClienteComum(clientefisico);
        Assert.assertNull(fachada.pesquisarClienteFisico(clientefisico.getCpf()));
        Assert.assertEquals(null, fachada.pesquisarClienteFisico(clientefisico.getCpf()));
          
    }
    
    @Test
    
    public void CancelarCadastroPessoaJuridicaVip() throws IOException, ClassNotFoundException{
        
        Fachada fachada = new Fachada();
        
         GerenteCliente gerente = new GerenteCliente();
        Assert.assertNull(fachada.pesquisarClienteJuridicoVip(null));
        
        ClienteJuridico clientejuridico = new ClienteJuridico();
        clientejuridico.setNome("Google");
        
        fachada.cadastroClienteVipPessoaJuridica(clientejuridico.getCpf());
        Assert.assertNotNull(clientejuridico.getNome(),clientejuridico.getTel());
        fachada.cancelarCadastroClienteVipPessoaJuridica(clientejuridico.getCnpj(),clientejuridico.getTel());
        Assert.assertNull(fachada.pesquisarClienteJuridicoVip(clientejuridico.getCnpj()));
        Assert.assertEquals(null, fachada.pesquisarClienteJuridicoVip(clientejuridico.getCnpj()));
          
    }
    
    
    @Test
    
    public void CancelarCadastroPessoaJuridicaComum() throws IOException, ClassNotFoundException{
        
        Fachada fachada = new Fachada();
       
        GerenteCliente gerente = new GerenteCliente();
        Assert.assertNull(fachada.pesquisarClienteJuridico(null));
      
        
        ClienteJuridico clientejuridico = new ClienteJuridico();
        clientejuridico.setNome("Vox Tecnologia");
        clientejuridico.setCnpj("065.465.540001-34");
        fachada.cadastrarClienteJuridico(clientejuridico);
   
        Assert.assertNotNull(clientejuridico.getNome(),clientejuridico.getTel());
        fachada.cancelarCadastroClienteJuridicoComum(clientejuridico);
        Assert.assertNull(fachada.pesquisarClienteJuridico(clientejuridico.getCnpj()));
        Assert.assertEquals(null, fachada.pesquisarClienteJuridico(clientejuridico.getCnpj()));
          
        
    
    }
    
    @Test
    public void pesquisarClienteTest() throws VeiculoExistenteException, IOException, ClassNotFoundException {

        Fachada fachadatest = new Fachada();
        Assert.assertNull(fachadatest.pesquisarClienteFisico("ANTONIETA"));
        Assert.assertNull(fachadatest.pesquisarClienteJuridico("ANTONIETA"));
        ClienteFisico maria = new ClienteFisico("Maria", "12345", "34333333");
        ClienteJuridico antonia = new ClienteJuridico("Antonia", "54321", "34333333");
        fachadatest.cadastrarClienteFisico(maria);
        fachadatest.cadastrarClienteJuridico(antonia);
        Assert.assertTrue(maria.getCpf().equals(antonia.getTelefone()));
        Assert.assertFalse("Maria", maria.equals(antonia));
        Assert.assertFalse(fachadatest.pesquisarClienteFisico(maria.getCpf()).equals(fachadatest.pesquisarClienteJuridico(antonia.getCpf())));
        Assert.assertNotNull(fachadatest.pesquisarClienteFisico(maria.getCpf()));
        Assert.assertNotNull(fachadatest.pesquisarClienteJuridico(antonia.getCpf()));
    }

    @Test
    public void pesquisarFuncionarioTest() throws funcionarioExistenteException, IOException, ClassNotFoundException, VeiculoExistenteException {

        Fachada f = new Fachada();
        Assert.assertNull(f.pesquisarFuncionario("Antonia"));
        Funcionario junior = new Funcionario();
        Fachada f2 = new Fachada();
        junior.setNome("junior");
        junior.setCpf("01214781497");
        junior.setEndereco("JPA");
        junior.setLogin("@JuniorSiqueira");
        junior.setSenha("APS");
        
        f.CadastrarFuncionario(junior);
        Assert.assertNotNull(junior);
       
        f.pesquisarFuncionario(junior.getCpf());
        Assert.assertTrue(f.pesquisarFuncionario(junior.getCpf()).equals(junior));
        Assert.assertTrue (f2.pesquisarFuncionario(junior.getCpf()).equals(junior));
        Funcionario Thiago = new Funcionario("Thiago", "06477688", "JPA", "@ThiagoMello", "APS");
        f.CadastrarFuncionario(Thiago);
        Assert.assertNotNull(f.pesquisarFuncionario(Thiago.getCpf()));
        Assert.assertFalse((f.pesquisarFuncionario(Thiago.getCpf()).equals(f.pesquisarFuncionario(junior.getCpf()))));
        f.DemitirFuncionario(Thiago.getCpf());
        Assert.assertEquals(f.pesquisarFuncionario(junior.getSenha()), f.pesquisarFuncionario(Thiago.getSenha()));
    }

    @Test
    public void test() throws VeiculoExistenteException, IOException, ClassNotFoundException {

        
        Fachada fachada = new Fachada();
        Veiculo v = new Veiculo();
        v.setCor("Rosa");
        v.setPlaca("333-ddd");
        v.setModelo("ford-Ka");
        fachada.cadastrarVeiculo(v);
        
        Assert.assertNotNull(fachada.pesquisarVeiculo(v.getPlaca()));
        Assert.assertEquals(v, fachada.pesquisarVeiculo("333-ddd"));
    }

    @Test
    public void testLavar() throws VeiculoExistenteException, IOException, ClassNotFoundException {

        
        Fachada fachada = new Fachada();

        Veiculo v = new Veiculo();
        v.setCor("Rosa");
        v.setPlaca("333-ddd");
        v.setModelo("ford-Ka");

        fachada.cadastrarVeiculo(v);
        fachada.lavarCarro(v);

        Assert.assertTrue(fachada.pesquisarVeiculo(v.getPlaca()).isLavado());
        Assert.assertNotNull(fachada.pesquisarVeiculo("333-ddd").isLavado());
        Assert.assertEquals(v.getCor(),fachada.pesquisarVeiculo("333-ddd").getCor());
        Assert.assertEquals(v.getModelo(),fachada.pesquisarVeiculo("333-ddd").getModelo());
        Assert.assertEquals(v.getPlaca(),fachada.pesquisarVeiculo("333-ddd").getPlaca());
        Assert.assertEquals(v,fachada.pesquisarVeiculo("333-ddd"));
     
    }

    @Test
    public void testPolir() throws VeiculoExistenteException, IOException, ClassNotFoundException {

        Fachada fachada = new Fachada();
        Veiculo v = new Veiculo();
        v.setCor("Rosa");
        v.setPlaca("333-ddd");
        v.setModelo("ford-Ka");
        fachada.polirCarro(v);
        fachada.cadastrarVeiculo(v);
        Assert.assertTrue(fachada.pesquisarVeiculo("333-ddd").isPolido());
        Assert.assertEquals(v.isPolido(),fachada.pesquisarVeiculo("333-ddd").isPolido());

        
        Fachada fachada2 = new Fachada();
        Assert.assertTrue(fachada2.pesquisarVeiculo("333-ddd").isPolido());
        Assert.assertEquals(v.isPolido(),fachada2.pesquisarVeiculo("333-ddd").isPolido());
    }

    @Test
    public void testTrocarOleo() throws VeiculoExistenteException, IOException, ClassNotFoundException {

        Fachada fachada = new Fachada();
        Veiculo v = new Veiculo();
        v.setCor("Rosa");
        v.setPlaca("333-ddd");
        v.setModelo("ford-Ka");
        fachada.trocarOleoCarro(v);
        fachada.cadastrarVeiculo(v);
        Assert.assertTrue(fachada.pesquisarVeiculo("333-ddd").isTroca_oleo());
        Assert.assertEquals(v.isTroca_oleo(),fachada.pesquisarVeiculo("333-ddd").isTroca_oleo());

        Fachada fachada2 = new Fachada();
         Assert.assertTrue(fachada2.pesquisarVeiculo("333-ddd").isTroca_oleo());
        Assert.assertEquals(v.isTroca_oleo(),fachada2.pesquisarVeiculo("333-ddd").isTroca_oleo());

    }

    @Test
    public void testNaoLavados() throws VeiculoExistenteException, IOException, ClassNotFoundException {

        Fachada fachada = new Fachada();
        Veiculo v = new Veiculo();
        v.setCor("Rosa");
        v.setPlaca("333-ddd");
        v.setModelo("ford-Ka");
        fachada.cadastrarVeiculo(v);
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        veiculos.add(v);
        Assert.assertEquals(veiculos, fachada.carroNaoLavados());
        Assert.assertEquals(v.isLavado(),fachada.pesquisarVeiculo("333-ddd").isLavado());
        Assert.assertFalse(fachada.pesquisarVeiculo("333-ddd").isLavado());
        

        Fachada fachada2 = new Fachada();
       Assert.assertEquals(v.isLavado(),fachada2.pesquisarVeiculo("333-ddd").isLavado());
       Assert.assertFalse(fachada2.pesquisarVeiculo("333-ddd").isLavado());
        
    }

    @Test
    public void valorServico() throws VeiculoExistenteException, IOException, ClassNotFoundException {

        Fachada fachada = new Fachada();
       
        Veiculo v = new Veiculo();
        v.setCor("Rosa");
        v.setPlaca("333-ddd");
        v.setModelo("ford-Ka");
        v.setLavado(true);
        v.setPolido(true);
        v.setTroca_oleo(true);
        
        fachada.cadastrarVeiculo(v);
        float valor = 80;
        Assert.assertEquals("" + valor, "" + fachada.valorSevico(v));
        v.setTroca_oleo(true);
        System.out.println(valor + ""+ fachada.valorSevico(v));
        Assert.assertEquals(""+ valor, "" + fachada.valorSevico(v));
        
         Fachada fachada2 = new Fachada();
        Assert.assertEquals("" + valor, "" + fachada2.valorSevico(v));
        v.setTroca_oleo(true);
        System.out.println(valor + ""+ fachada2.valorSevico(v));
        Assert.assertEquals(""+ valor, "" + fachada2.valorSevico(v));
    }
}