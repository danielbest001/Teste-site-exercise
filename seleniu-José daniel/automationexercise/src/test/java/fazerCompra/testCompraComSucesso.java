package fazerCompra;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testCompraComSucesso {

	private pageObjectCompra paginaDeCcompras;
	
	@Before
	 public void Before () {
		 this.paginaDeCcompras = new pageObjectCompra ();
	 }
	
	 @After
	 
	 public void After () {
		 this.paginaDeCcompras.fecharBrowser();
	 }
		
	 @Test
	    public void testcarrinho() {
		 
		 //Entrar em uma conta existente
		 paginaDeCcompras.fazerLoginComContaExistente("daniel@teste", "suaSenha");
		 
		 //Aperdar no botão de login
		 paginaDeCcompras.submitLogin();
		
		 //Passar o mouse sobre o Produto
		 paginaDeCcompras.passeMouseSobrePoduto();
		
		 //Adicionar o produto ao carrinho
		 paginaDeCcompras.adicionarProdutoAoCarrinho();
		
		 //Visualizar produtos no carrinho
		 paginaDeCcompras.visualizarCarrinho();
		 
		 //botão de processar compras
		 paginaDeCcompras.processarCompras();
		 
		//comentario sobre a compra
		 paginaDeCcompras.comentarioSobreCompra();
		 
		//Fazer pedido
		 paginaDeCcompras.fazerPedido();
		 
		//Medoto de pagamento
		 paginaDeCcompras.metodoDePagamento();
		 
		 // botão para validar metodo de pagamento
		 paginaDeCcompras.BotaoMedotodepagamento();
		 
		 //verificar mensagem de compra finalizada
		 paginaDeCcompras.ValidarMensagemDeCompraFinalizada();
	 }
}
