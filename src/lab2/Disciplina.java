package lab2;

import java.util.Arrays;

/**
 * Respons�vel por manter as informa��es acerca de uma determinada disciplina, armazenando informa��es como horas, 
 * notas, media.
 * 
 * @author Euclides Ramos - 117210377
 */
public class Disciplina {
	
	/**
	 * Armazena o nome da disciplina a ser detalhada.
	 */
	private String nomeDisciplina;
	
	/**
	 * Quantidade de horas para a determinada disciplina.
	 */
	private int horas;
	
	/**
	 * Array que armazena as notas para a disciplina informada.
	 */
	private double[] notas;
	
	/**
	 * Array que armazena os pesos de cada nota da disciplina.
	 */
	private int[] pesos;
	
	/**
	 * Constr�i uma disciplina com nome passado como par�metro.
	 * 
	 * @param nomeDisciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[4];
		this.pesos = new int[4];
	}
	
	/**
	 * Constr� uma disciplina como nome passado como par�metro e tamb�m a quantidade de notas dessa disciplina.
	 * 
	 * @param nomeDisciplina
	 * @param qntdNotas
	 */
	public Disciplina(String nomeDisciplina, int qntdNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[qntdNotas];
		this.pesos = new int[qntdNotas];
	}
	
	/**
	 * Constr� uma disciplina como nome passado como par�metro, a quantidade de notas dessa disciplina e o peso de 
	 * cada uma delas.
	 * 
	 * @param nomeDisciplina
	 * @param qntdNotas
	 * @param pesos
	 */
	public Disciplina(String nomeDisciplina, int qntdNotas, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[qntdNotas];
		this.pesos = pesos;
	}
	
	/**
	 * Cadastra a quantidade de horas para a determinada disciplina construida.
	 * 
	 * @param horas
	 */
	public void cadastraHoras(int horas) {
		this.horas = horas;
	}
	
	/**
	 * Armazena as notas, passadas como par�metro, nas posi��es informadas.
	 * 
	 * @param nota Informa qual a nota a ser cadastrada
	 * @param valorNota Informa o valor na nota (de 0.0 a 10.0)
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
	 * Calcula a m�dia aritm�tica ou ponderada das notas da disciplina e, logo ap�s, faz o retorno da mesma.
	 * 
	 * @param notas
	 * @return
	 */
	private double CalculaMedia(double[] notas, int[] pesos) {
		int soma = 0;
		int somaPesos = 0;
		for (int i = 0; i < notas.length; i++) {
			if (pesos[i] == 0) {
				somaPesos = notas.length;
				soma += notas[i];
			} else {
				somaPesos += pesos[i];
				soma += notas[i] * pesos[i];
			}
		}
		
		double media = (double)soma / somaPesos;
		return media;
	}
	
	/**
	 * Verifica se o aluno foi aprovado. Caso ele tenha sido aprovado, o retorno ser� "true", caso contr�rio, ser� "false".
	 * 
	 * @return representa��o booleana para o estado do aluno na disciplina (aprovado ou reprovado).
	 */	
	public boolean aprovado() {
		if (CalculaMedia(notas, pesos) >= 7.0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna a String com o nome da Disciplina.
	 * 
	 * @return
	 */
	public String getNome() {
		return nomeDisciplina;
	}
	
	/**
	 * Retona a String que representa a disciplina e os seus atributos no seguinte formato: 
	 * "NOME DA DISCIPLINA horas M�DIA notas".
	 * 
	 * @return
	 */
	public String toString() {
		return nomeDisciplina + " " + horas + " " + CalculaMedia(notas, pesos) + " " + Arrays.toString(notas);
	}
}