package lab2;

/**
 * Responsável por manter o registro da quantidade de espaço utilizado em determinado laboratório.
 *
 * @author Euclides Ramos - 117210377
 */
public class ContaLaboratorio {
	
	/**
	 * Armazena o nome do determinado laboratório.
	 */
	private String nomeLaboratorio;
	
	/**
	 * Armazena a cota (limite) de dados para cada laboratório.
	 */
	private int cota;
	
	/**
	 * Armazena o consumo de espaço em um determinado laboratório.
	 */
	private int espacoOcupado;
	
	/**
	 * Constrói um laboratório com nome passado como parâmetro e tamanho defaut de cota (2000 MB). O espaço ocupado, 
	 * a priori, é 0 MB.
	 * 
	 * @param nomeLaboratorio
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
	
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
		this.espacoOcupado = 0;
	}
	
	/**
	 * Constrói um laboratório com nome passado como parâmetro e tamanho definido pelo usuário, também passado como 
	 * parâmetro. O espaço ocupado, a priori, é 0 MB.
	 * 
	 * @param nomeLaboratorio
	 * @param cota
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
		this.espacoOcupado = 0;
	}
	
	/**
	 * Aumenta o espaço ocupado (consumido) no laboratório, incremetando a quantidade de mbytes que é passado como 
	 * parâmetro.
	 * 
	 * @param mbytes
	 */
	public void consomeEspaco(int mbytes) {
		
		this.espacoOcupado += mbytes;
	}
	
	/**
	 * Libera o espaço ocupado no laboratório, decrementando a quantidade de mbytes que é passado como parâmetro.
	 * 
	 * @param mbytes
	 */
	public void liberaEspaco(int mbytes) {
		
		this.espacoOcupado -= mbytes;
	}
	
	/**
	 * Verifica se o aluno atingiu a cota predeterminada anteriormente. Retorna "true" para quando a cota for atingida 
	 * ou "false", caso ainda não tenha sido atingida.
	 * 
	 * @return representação booleana para informar se a cota foi atingida.
	 */
	public boolean atingiuCota() {
		
		if (espacoOcupado >= cota) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna a String com o nome do Laboratório.
	 * 
	 * @return
	 */
	public String getNome() {
		return nomeLaboratorio;
	}
	
	/**
	 * Retorna a String que informa o nome do laboratório criado juntamente com informações sobre o espaço ocupado e a 
	 * cota. A representação segue no formato: "Nome do Laboratório ESPAO OCUPADO/Cota".
	 * 
	 * @return
	 */
	public String toString() {
		
		return nomeLaboratorio + " " + espacoOcupado + "/" + cota;
	}
}