package agendaPrincipal;

/**
 * Encapsula os hor�rios para agregar no per�odo.
 * <p>
 * Podemos definir um hor�rio por inteiros (horas e minutos) e 
 * por String "HORAS:MINUTOS", e o formato das horas s�o: 0 a 
 * 23 horas e 0 a 59 minutos.
 * <p>
 * Usaremos essa classe para agregar a classe Periodo. Na agenda,
 * iremos usar dois hor�rios, o inicial e o final.
 * @author Rafael Emery
 * @version 1.0
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Horario implements Serializable{
	private int horas, minutos;
	
	//Metodos construtores	
	/**
	 * Construtor para o objeto vazio
	 * @throws Exception caso n�o possua hor�rio
	 */
	public Horario() throws Exception {
		throw new Exception("Horario vazio. Digite aqui");
	}
	/**
	 * Construtor para inicializar os campos do objeto
	 * @param _horas horas do hor�rio
	 * @param _minutos minutos do hor�rio
	 * @throws Exception problemas na inser��o
	 */
	public Horario(int _horas, int _minutos) throws Exception {
		this.setHorario(_horas, _minutos);
	}
	/**
	 * Construtor para inicializar o objeto com uma String
	 * @param _horario String "XX:XX" para o objeto
	 * @throws Exception problemas na inser��o
	 */
	public Horario(String _horario) throws Exception {
		this.setHorario(_horario);
	}
	
	//Metodos set
	/**
	 * M�todo para inserir o hor�rio 
	 * @param _horas inteiro de horas
	 * @param _minutos inteiro de minutos
	 * @throws Exception hor�rio inv�lido de acordo com isHorarioValido
	 */
	public void setHorario(int _horas, int _minutos) throws Exception {
		if (Horario.isHorarioValido(_horas, _minutos)) {
			this.horas = _horas;
			this.minutos = _minutos;
		}
		else {
			throw new Exception("Horario invalido");
		}
	}	
	/**
	 * Insere um hor�rio em String. Optamos por usar esse m�toto set 
	 * na Agenda pela facilidade de digita��o.
	 * <p>
	 * O m�todo usa o indexOf, substring e parseInt para pegar o �ndice
	 * e as strings e fazer a convers�o para inteiro, entrando com o 
	 * setHorario padr�o (inteiros)
	 * @param _horario Um objeto de Horario
	 * @throws Exception Caso o hor�rio seja inv�lido
	 */
	public void setHorario(String _horario) throws Exception {
		int index1 = _horario.indexOf(":");
		String _horas = _horario.substring(0, index1);
		String _minutos = _horario.substring(index1 + 1, index1 + 3);
		int horas = Integer.parseInt(_horas);
		int minutos = Integer.parseInt(_minutos);
		this.setHorario(horas, minutos);
	}
	
	//Metodos get
	public int getHoras() {
		return this.horas;
	}
	public int getMinutos() {
		return this.minutos;
	}
	
	//Metodos para validar o horario	
	/** 
	 * Verifica se um hor�rio � v�lido
	 * @return Um booleano que representa a validade do hor�rio
	 */
	public boolean isHorarioValido() {
		return Horario.isHorarioValido(this.getHoras(), this.getMinutos());
	}
	/**
	 * Verifica se um hor�rio � v�lido
	 * @param horas As horas do objeto
	 * @param minutos Os minutos do objeto
	 * @return Um booleano que representa a validade do hor�rio
	 */
	public static boolean isHorarioValido(int horas, int minutos) {
		if ((horas >= 0 && horas <= 23) && (minutos >= 0 && minutos <= 59)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo compareTo
	/**
	 * M�todo que faz uma compara��o entre dois hor�rios e retorna
	 * um inteiro
	 * @param obj Objeto qualquer para fazer um cast
	 * @return Um inteiro que representa se � maior, igual ou
	 * menor que o objeto em quest�o
	 */
	public int compareTo(Object obj) {
		Horario aux = (Horario) obj;
		if (this.getHoras() > aux.getHoras()) {
			return 1;
		}
		else if (this.getHoras() == aux.getHoras()) {
			if (this.getMinutos() > aux.getMinutos()) {
				return 1;
			}
			else if (this.getMinutos() == aux.getMinutos()) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}
	
	//Metodo equals
	/**
	 * M�todo que verifica se dois objetos s�o iguais e retorna um 
	 * booleano
	 * @param obj Objeto qualquer para se fazer um cast
	 * @return Um booleano que representa se os objetos s�o iguais ou n�o
	 */
	public boolean equals(Object obj) {
		Horario aux = (Horario) obj;
		if (this.getHoras() == aux.getHoras() && this.getMinutos() == aux.getMinutos()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder horario = new StringBuilder();
		horario.append(this.getHoras());
		horario.append(":");
		horario.append(this.getMinutos());
		return horario.toString();
	}
	
}
