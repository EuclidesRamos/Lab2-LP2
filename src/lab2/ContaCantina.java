package lab2;

/**
 * Controla a movimentação (compras, gastos) das compras do aluno em uma cantina.
 * 
 * @author Euclides Ramos - 117210377
 */
public class ContaCantina {
	
	/**
	 * Armazena o nome da cantina que será construída.
	 */
	private String nomeDaCantina;
	
	/**
	 * Aramazena a quantidade de itens que foram comprados na cantina.
	 */
	private int qtdItens;
	
	/**
	 * Armazena o valor, em centavos, dos itens que foram comprados.
	 */
	private int valorCentavos;
	
	/**
	 * Array para armazenar os últimos 5 detalhes das compras realizadas na cantina.
	 */
	private String[] detalhes = new String[5];
	
	/**
	 * Constrói uma cantina com nome passado como parâmetro.
	 * 
	 * @param nomeDaCantina
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
	}
	
	/**
	 * Cadastra os lanches comprados, informado a quantidade de itens e o valor, em centavos, de todos os itens.
	 * 
	 * @param qtdItens
	 * @param valorCentavos
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.qtdItens += qtdItens;
		this.valorCentavos += valorCentavos;
	}
	
	/**
	 * Cadastra lanches comprados, incluindo detalhes sobre o pedido, além da quantidade de itens e o valor, em centavos, 
	 * de cada item.
	 * 
	 * @param qtdItens
	 * @param valorCentavos
	 * @param detalhes
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
		organizaDetalhes(this.detalhes);
		this.qtdItens += qtdItens;
		this.valorCentavos += valorCentavos;
		this.detalhes[4] = detalhes;
	}
	
	
	/**
	 * Organiza o array de detalhes em ordem de mais antigo para mais novo, fazendo com que a visibilidade seja melhor.
	 * @param detalhes
	 */
	private void organizaDetalhes(String[] detalhes) {
		for (int i = 0; i < detalhes.length - 1; i++) {
			detalhes[i] = detalhes[i + 1];
		}
	}
	
	/**
	 * Decrementa, da dívida com a cantina, o valor, em centavos, pago pelo aluno.
	 * 
	 * @param valorCentavos
	 */
	public void pagaConta(int valorCentavos) {
		this.valorCentavos -= valorCentavos;
	}
	
	
	/**
	 * Retorna a String que representa a cantina, com suas informações associadas com no seguinte formato: 
	 * "Nome da Cantina QUANTIDADE DE ITENS COMPRADOS Dívida do aluno" 
	 * 
	 */
	public String toString() {
		return nomeDaCantina + " " + qtdItens + " " + valorCentavos;
	}
	
	/**
	 * Retorna a String com o nome da Cantina.
	 * 
	 * @return
	 */
	public String getNome() {
		return nomeDaCantina;
	}
	
	/**
	 * Retorna a String contendo os detalhes da ultimas 5 compras que foram detalhadas, em ordem de detalhe de compra 
	 * mais antiga para detalhe de compra mais atual.
	 * 
	 * @return
	 */
	public String listarDetalhes() {
		String mensagem = "";
		for (int i = 0; i < detalhes.length; i++) {
			if (i == detalhes.length + 1) {
				mensagem += detalhes[i];
			} else {
				mensagem += detalhes[i] + ", ";
			}
		}
		System.out.println(mensagem);
		return mensagem;
	}
}