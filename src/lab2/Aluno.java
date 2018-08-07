package lab2;

import java.util.ArrayList;

/**
 * Classe responsavel por armazenar todas as informacoes relacionadas ao Aluno (Informacoes sobre os Laboratorios, sobre as Disciplinas, sobre as Cantinas e sobre a Saude.
 * 
 * @author Euclides Ramos - 117210377
 */
public class Aluno {

	/**
	 * Armazena o nome do aluno que foi cadastrado.
	 */	
	private String nomeAluno;
	
	/**
	 * Lista para armazenar todos os laboratorios associados ao aluno.
	 */
	private ArrayList<ContaLaboratorio> laboratorios;
	
	/**
	 * Lista para armazenar todas as cantinas em que o aluno possui conta.
	 */
	private ArrayList<ContaCantina> cantinas;
	
	/**
	 * Lista para armazenar todas as disciplinas que o aluno tem vinculo.
	 */
	private ArrayList<Disciplina> disciplinas;
	
	/**
	 * Objeto para armazenar o estado de saúde do aluno.
	 */
	private Saude estadoSaude = new Saude();
	
	/**
	 * Constroi o objeto aluno e cria as listas para armazenar as informacoes do mesmo.
	 * 
	 * @param nome Nome do aluno.
	 */
	public Aluno(String nome) {
		this.nomeAluno = nome;
		this.laboratorios = new ArrayList<>();
		this.cantinas = new ArrayList<>();
		this.disciplinas = new ArrayList<>();
	}
	
	/**
	 * Cadastra um novo laboratorio associado a aluno, passando apenas o nome do laboratorio como parametro.
	 * 
	 * @param nomeLaboratorio Nome do laboratorio a ser cadastrado.
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		ContaLaboratorio lab = new ContaLaboratorio(nomeLaboratorio);
		this.laboratorios.add(lab);
	}
	
	/**
	 * Cadastra um nome laboratório associado a aluno, informando o nome do laboratório e também a cota do aluno.
	 * 
	 * @param nomeLaboratorio Nome do laboratorio a ser cadastrado.
	 * @param cota Cota do laboratorio
	 */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		ContaLaboratorio lab = new ContaLaboratorio(nomeLaboratorio, cota);
		this.laboratorios.add(lab);
	}
	
	/**
	 * Aumenta o espaço ocupado (consumido) no laboratorio passado no parametro.
	 * 
	 * @param nomeLaboratorio Nome do laboratorio a ser capturado.
	 * @param mbytes Quantidade a ser consumida da cota do laboratorio.
	 */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		int indice = encontraElementoLaboratorio(nomeLaboratorio);
		laboratorios.get(indice).consomeEspaco(mbytes);
	}
	
	/**
	 * Libera o espaço ocupado no laboratorio passado no parametro.
	 * 
	 * @param nomeLaboratorio Nome do laboratorio a ser capturado.
	 * @param mbytes Quantidade a ser liberada da cota do laboratorio.
	 */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		int indice = encontraElementoLaboratorio(nomeLaboratorio);
		laboratorios.get(indice).liberaEspaco(mbytes);
	}
	
	/**
	 * Verifica se o aluno atingiu a cota predeterminada anteriormente para o laboratorio que foi passado como parametro.
	 * 
	 * @return Retorna uma representacao booleana para informar se a cota foi atingida.
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		int indice = encontraElementoLaboratorio(nomeLaboratorio);
		return laboratorios.get(indice).atingiuCota();
	}
	
	/**
	 * Retorna a String com as informacoes acerca do laboratorio que foi passado como parametro.
	 * 
	 * @return Retorna uma representacao em String do laboratorio.
	 */
	public String laboratorioToString(String nomeLaboratorio) {
		int indice = encontraElementoLaboratorio(nomeLaboratorio);
		return laboratorios.get(indice).toString();
	}
	
	/**
	 * Cadastra uma nova disciplina que sera vinculada a aluno.
	 * 
	 * @param nomeDisciplina Nome da disciplina a ser cadastrada.
	 */
	public void cadastraDisciplina(String nomeDisciplina) {
		Disciplina nome = new Disciplina(nomeDisciplina);
		this.disciplinas.add(nome);
	}
	
	/**
	 * Cadastra a quantidade de horas da disciplina passada como parametro.
	 * 
	 * @param nomeDisciplina Nome da disciplina a ser capturada.
	 * @param horas Quantidade de horas a ser cadastrada.
	 */
	public void cadastraHoras(String nomeDisciplina, int horas) {
		int indice = encontraElementoDisciplina(nomeDisciplina);
		disciplinas.get(indice).cadastraHoras(horas);
	}
	
	/**
	 * Cadastra a nota associadas a disciplina passada como parametro.
	 * 
	 * @param nomeDisciplina Nome da disciplina a ser capturada.
	 * @param nota Nota a ser adicionada a disciplina.
	 * @param valorNota Valor da nota a ser adicionada.
	 */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		int indice = encontraElementoDisciplina(nomeDisciplina);
		disciplinas.get(indice).cadastraNota(nota, valorNota);
	}	
	
	/**
	 * Verifica se o aluno esta aprovado na disciplina especificada.
	 * 
	 * @param nomeDisciplina Nome da disciplina a ser capturada.
	 * @return Retorna "true" ou "false".
	 */
	public boolean aprovado(String nomeDisciplina) {
		int indice = encontraElementoDisciplina(nomeDisciplina);
		return disciplinas.get(indice).aprovado();
	}
	
	/**
	 * Retorna a String com todas as informacoes sobre a disciplina especificada do aluno.
	 * 
	 * @param nomeDisciplina Nome da disciplina a ser capturada.
	 * @return Retorna uma representacao em String da disciplina.
	 */
	public String disciplinaToString(String nomeDisciplina) {
		int indice = encontraElementoDisciplina(nomeDisciplina);
		return disciplinas.get(indice).toString();
	}
	
	/**
	 * Cadastra uma nova Cantina em que o aluno possui conta.
	 * 
	 * @param nomeCantina
	 */
	public void cadastraCantina(String nomeCantina) {
		ContaCantina nome = new ContaCantina(nomeCantina);
		this.cantinas.add(nome);
	}
	
	/**
	 * Cadastra os lanches comprados na cantina que foi passada como paramentro. Tambem cadastra o valor dos itens, em centavos.
	 * 
	 * @param nomeCantina
	 * @param qtdItens
	 * @param valorCentavos
	 */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		int indice = encontraElementoCantina(nomeCantina);
		cantinas.get(indice).cadastraLanche(qtdItens, valorCentavos);
	}
	
	/**
	 * Debita da conta, na cantina especificada, do aluno.
	 * 
	 * @param nomeCantina
	 * @param valorCentavos
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		int indice = encontraElementoCantina(nomeCantina);
		this.cantinas.get(indice).pagaConta(valorCentavos);
	}
	
	/**
	 * Retorna a String com todos os detalhes da cantina que foi passada como parametro.
	 * 
	 * @param nomeCantina
	 * @return
	 */
	public String cantinaToString(String nomeCantina) {
		int indice = encontraElementoCantina(nomeCantina);
		return cantinas.get(indice).toString();
	}
	
	/**
	 * Define a saude mental do aluno, informando se esta boa ou fraca.
	 * 
	 * @param valor
	 */
	public void defineSaudeMental(String valor) {
		this.estadoSaude.defineSaudeMental(valor);
	}
	
	/**
	 * Define a saude fisica do aluno, informando se esta boa ou fraca.
	 * @param valor
	 */
	public void defineSaudeFisica(String valor) {
		this.estadoSaude.defineSaudeFisica(valor);
	}
	
	/**
	 * Retorna a String com informações sobre a saude geral do aluno.
	 * 
	 * @return
	 */
	public String getStatusGeral() {
		return this.estadoSaude.getStatusGeral();
	}
	
	/**
	 * Procura determinado elemento no ArrayList laboratorios e retorna o indice desse elemento.
	 * 
	 * @param nomeElemento
	 * @return
	 */
	private int encontraElementoLaboratorio(String nomeElemento) {
		for (int i = 0; i < this.laboratorios.size(); i++) {
			if (this.laboratorios.get(i).getNome().equals(nomeElemento)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Procura determinado elemento no ArrayList disciplinas e retorna o indice desse elemento.
	 * 
	 * @param nomeElemento
	 * @return
	 */
	private int encontraElementoDisciplina(String nomeElemento) {
		for (int i = 0; i < this.disciplinas.size(); i++) {
			if (this.disciplinas.get(i).getNome().equals(nomeElemento)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Procura determinado elemento no ArrayList cantinas e retorna o indice desse elemento.
	 * 
	 * @param nomeElemento
	 * @return
	 */
	private int encontraElementoCantina(String nomeElemento) {
		for (int i = 0; i < this.cantinas.size(); i++) {
			if (this.cantinas.get(i).getNome().equals(nomeElemento)) {
				return i;
			}
		}
		return -1;
	}
}