package lab2;

/**
 * Respons�vel por manter o registro da quantidade de espa�o utilizado em determinado laborat�rio.
 *
 * @author Euclides Ramos - 117210377
 */
public class ContaLaboratorio {
	
	/**
	 * Armazena o nome do determinado laborat�rio.
	 */
	private String nomeLaboratorio;
	
	/**
	 * Armazena a cota (limite) de dados para cada laborat�rio.
	 */
	private int cota;
	
	/**
	 * Armazena o consumo de espa�o em um determinado laborat�rio.
	 */
	private int espacoOcupado;
	
	/**
	 * Constr�i um laborat�rio com nome passado como par�metro e tamanho defaut de cota (2000 MB). O espa�o ocupado, 
	 * a priori, � 0 MB.
	 * 
	 * @param nomeLaboratorio
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
	
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
		this.espacoOcupado = 0;
	}
	
	/**
	 * Constr�i um laborat�rio com nome passado como par�metro e tamanho definido pelo usu�rio, tamb�m passado como 
	 * par�metro. O espa�o ocupado, a priori, � 0 MB.
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
	 * Aumenta o espa�o ocupado (consumido) no laborat�rio, incremetando a quantidade de mbytes que � passado como 
	 * par�metro.
	 * 
	 * @param mbytes
	 */
	public void consomeEspaco(int mbytes) {
		
		this.espacoOcupado += mbytes;
	}
	
	/**
	 * Libera o espa�o ocupado no laborat�rio, decrementando a quantidade de mbytes que � passado como par�metro.
	 * 
	 * @param mbytes
	 */
	public void liberaEspaco(int mbytes) {
		
		this.espacoOcupado -= mbytes;
	}
	
	/**
	 * Verifica se o aluno atingiu a cota predeterminada anteriormente. Retorna "true" para quando a cota for atingida 
	 * ou "false", caso ainda n�o tenha sido atingida.
	 * 
	 * @return representa��o booleana para informar se a cota foi atingida.
	 */
	public boolean atingiuCota() {
		
		if (espacoOcupado >= cota) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna a String com o nome do Laborat�rio.
	 * 
	 * @return
	 */
	public String getNome() {
		return nomeLaboratorio;
	}
	
	/**
	 * Retorna a String que informa o nome do laborat�rio criado juntamente com informa��es sobre o espa�o ocupado e a 
	 * cota. A representa��o segue no formato: "Nome do Laborat�rio ESPAO OCUPADO/Cota".
	 * 
	 * @return
	 */
	public String toString() {
		
		return nomeLaboratorio + " " + espacoOcupado + "/" + cota;
	}
}