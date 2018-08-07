package lab2;

/**
 * Responsável por armazenar informações sobre a saúde do aluno, informando a saúde física e mental.
 * 
 * @author Euclides Ramos - 117210377
 */
public class Saude {
	
	/**
	 * Armazena a informação sobre o estado da saúde mental do aluno, podendo ser ""fraca" ou "boa".
	 */
	private String valorMental;
	
	/**
	 * Armazena a informação sobre o estado da saúde física do aluno, podendo ser ""fraca" ou "boa".
	 */
	private String valorFisica;
	
	/**
	 * Armazena a informação sobre o estado geral do aluno, podendo ser ""fraca", "ok" ou "boa".
	 */
	private String saudeGeral;

	/**
	 * Armazena o emoji que descreve a situação mental do aluno.
	 */
	private String emoji;
	
	/**
	 * Verifica a saúde geral do aluno, verificando a saúde física e mental do mesmo.
	 * 
	 * @param saudeMental
	 * @param saudeFisica
	 * @return Retorna a saúde geral do aluno.
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
	 * Contrói a saúde do aluno, definindo as duas, a princípio, como "boa".
	 */
	public Saude() {
		this.valorMental = "boa";
		this.valorFisica = "boa";
	}
	
	/**
	 * Define a informação sobre a saúde mental do aluno.
	 * 
	 * @param valor Estado da saúde mental do aluno.
	 */
	public void defineSaudeMental(String valor) {
		this.valorMental = valor;
	}
	
	/**
	 * Define a informação sobre a saúde física do aluno.
	 * 
	 * @param valor estado da saúde física do aluno.
	 */
	public void defineSaudeFisica(String valor) {
		this.valorFisica = valor;
	}
	
	/**
	 * Define a sensação geral do aluno em forma de emoji.
	 * @param emoji
	 */
	public void defineSensacaoGeral(String emoji) {
		this.emoji = emoji;
	}
	
	/**
	 * Retorna a string que representa, no geral, a saúde do aluno. Caso a saúde física e mental forem ambas "boa", então 
	 * a string de retorno virá com o emoji que foi definido anteriormente.
	 * 
	 * @return Os retornos possíveis são: "boa", "ok" ou "fraca", com ou sem emoji.
	 */
	public String getStatusGeral() {
		if (!valorFisica.equals("boa") || !valorMental.equals("boa")) {
			return verificaSaudeGeral(valorMental, valorFisica);
		} else {
			return verificaSaudeGeral(valorMental, valorFisica) + " " + emoji;
		}
	}
}