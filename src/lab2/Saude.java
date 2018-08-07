package lab2;

/**
 * Respons�vel por armazenar informa��es sobre a sa�de do aluno, informando a sa�de f�sica e mental.
 * 
 * @author Euclides Ramos - 117210377
 */
public class Saude {
	
	/**
	 * Armazena a informa��o sobre o estado da sa�de mental do aluno, podendo ser ""fraca" ou "boa".
	 */
	private String valorMental;
	
	/**
	 * Armazena a informa��o sobre o estado da sa�de f�sica do aluno, podendo ser ""fraca" ou "boa".
	 */
	private String valorFisica;
	
	/**
	 * Armazena a informa��o sobre o estado geral do aluno, podendo ser ""fraca", "ok" ou "boa".
	 */
	private String saudeGeral;

	/**
	 * Armazena o emoji que descreve a situa��o mental do aluno.
	 */
	private String emoji;
	
	/**
	 * Verifica a sa�de geral do aluno, verificando a sa�de f�sica e mental do mesmo.
	 * 
	 * @param saudeMental
	 * @param saudeFisica
	 * @return Retorna a sa�de geral do aluno.
	 */
	private String verificaSaudeGeral(String saudeMental, String saudeFisica) {
		
		if (saudeMental.equals("fraca") && saudeFisica.equals("fraca")) {
			saudeGeral = "fraca";
		} else if (saudeMental.equals("fraca") && saudeFisica.equals("boa")) {
			saudeGeral = "ok";
		} else if (saudeMental.equals("boa") && saudeFisica.equals("fraca")) {
			saudeGeral = "ok";
		} else {
			saudeGeral = "boa";
		}
		return saudeGeral;
	}
	
	/**
	 * Contr�i a sa�de do aluno, definindo as duas, a princ�pio, como "boa".
	 */
	public Saude() {
		this.valorMental = "boa";
		this.valorFisica = "boa";
	}
	
	/**
	 * Define a informa��o sobre a sa�de mental do aluno.
	 * 
	 * @param valor Estado da sa�de mental do aluno.
	 */
	public void defineSaudeMental(String valor) {
		this.valorMental = valor;
	}
	
	/**
	 * Define a informa��o sobre a sa�de f�sica do aluno.
	 * 
	 * @param valor estado da sa�de f�sica do aluno.
	 */
	public void defineSaudeFisica(String valor) {
		this.valorFisica = valor;
	}
	
	/**
	 * Define a sensa��o geral do aluno em forma de emoji.
	 * @param emoji
	 */
	public void defineSensacaoGeral(String emoji) {
		this.emoji = emoji;
	}
	
	/**
	 * Retorna a string que representa, no geral, a sa�de do aluno. Caso a sa�de f�sica e mental forem ambas "boa", ent�o 
	 * a string de retorno vir� com o emoji que foi definido anteriormente.
	 * 
	 * @return Os retornos poss�veis s�o: "boa", "ok" ou "fraca", com ou sem emoji.
	 */
	public String getStatusGeral() {
		if (!valorFisica.equals("boa") || !valorMental.equals("boa")) {
			return verificaSaudeGeral(valorMental, valorFisica);
		} else {
			return verificaSaudeGeral(valorMental, valorFisica) + " " + emoji;
		}
	}
}