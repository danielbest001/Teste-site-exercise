package Pesquisarproduto;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testePesquisarProduto {

	private pageObjectPesquisarProduto paginaDePesquisa;
	
	//atributo:
	
	@BeforeEach
	 public void Before () {
		 this.paginaDePesquisa= new pageObjectPesquisarProduto();
	 }
	
 @AfterEach
	 
	 public void After () {
		 this.paginaDePesquisa.fecharBrowser();
	 }
	 
	 @Test 
	 public void pesquisarProduto() {
		 //Fazer pesquisa do produto
		 paginaDePesquisa.pesquisarProduto();
		 //apertar no botão para submeter a pesquisa
		 paginaDePesquisa.submitPesquisa();
		 //checar se o produto pequisado foi exibido
		 paginaDePesquisa.checarProduto();
	 }
	 
	 
}
