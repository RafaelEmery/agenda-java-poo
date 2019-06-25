package agendaPrincipal;

/**
 * Encapsula o per�odo com datas e hor�rios para usar em Agenda
 * @author Rafael Emery
 * @version 1.0
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Periodo implements Serializable {
	private Data dataInicio, dataFinal;
	private Horario horarioInicio, horarioFinal;
	
	//Metodos construtores
	/**
	 * Construtor vazio para o objeto inicializado vazio
	 * @throws Exception caso o objeto seja vazio
	 */
	public Periodo() throws Exception {
		throw new Exception("Periodo vazio. Digite aqui.");
	}
	/**
	 * Construtor que inicializa um objeto com todos os argumentos
	 * @param _dataInicio data de inicio do per�odo
	 * @param _dataFinal data de final do per�odo
	 * @param _horarioInicio hor�rio da data inicial
	 * @param _horarioFinal hor�rio da data final
	 * @throws Exception caso as datas e/ou os hor�rios sejam inv�lidos
	 */
	public Periodo(Data _dataInicio, Data _dataFinal, Horario _horarioInicio, Horario _horarioFinal) throws Exception {
		this.setPeriodo(_dataInicio, _dataFinal, _horarioInicio, _horarioFinal);
	}
	
	//Metodos set	
	/**
	 * Insere e verifica um determinado per�odo de datas e horas
	 * @param _dataInicio Data inicial do per�odo
	 * @param _dataFinal Data final do per�odo
	 * @param _horarioInicio Hor�rio da data inicial
	 * @param _horarioFinal Hor�rio da data final
	 * @throws Exception Caso as datas e os hor�rios sejam inv�lidos
	 */
	public void setPeriodo(Data _dataInicio, Data _dataFinal, Horario _horarioInicio, Horario _horarioFinal) throws Exception {
		if (_dataInicio.compareTo(_dataFinal) <= 0) {
			this.dataInicio = _dataInicio;
			this.dataFinal = _dataFinal;
			this.horarioInicio = _horarioInicio;
			this.horarioFinal = _horarioFinal;
		}
		else {
			throw new Exception("Periodo invalido.");
		}
	}
	
	
	//Metodos get
	public Data getDataInicio() {
		return this.dataInicio;
	}
	public Data getDataFinal() {
		return this.dataFinal;
	}
	public Horario getHorarioInicio() {
		return this.horarioInicio;
	}
	public Horario getHorarioFinal() {
		return this.horarioFinal;
	}
	
	//Metodo equals
	/**
	 * M�todo que verifica se dois objetos s�o iguais e retorna um 
	 * booleano
	 * @param obj Objeto qualquer para se fazer um cast
	 * @return Um booleano que representa se os objetos s�o iguais ou n�o
	 */
	public boolean equals(Object obj) {
		Periodo aux = (Periodo) obj;
		if ((this.getDataInicio() == aux.getDataInicio() && this.getDataFinal() == aux.getDataFinal()) && 
		(this.getHorarioInicio() == aux.getHorarioInicio() && this.getHorarioFinal() == aux.getHorarioFinal())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Inicio: ");
		builder.append(this.getDataInicio());
		builder.append(" as ");
		builder.append(this.getHorarioInicio());
		builder.append(" - Final: ");
		builder.append(this.getDataFinal());
		builder.append(" as ");
		builder.append(this.getHorarioFinal());
		return builder.toString();
	}
	
}
