package agendaPrincipal;

/**
 * Encapsula um tipo de ItemAgenda chamado Meta.
 * <p>
 * Uma meta � �tem da agenda que possui como diferencial a
 * prioridade da meta (em inteiro).
 * <p>
 * A classe abaixo possui m�todos construtores, setters e getters,
 * equals e outros para a manipula��o de itens de agenda do tipo
 * Meta. Al�m disso implementa a interface Comparable para fazer 
 * a ordena��o e a Serializable para a grava��o em arquivo.
 * @author Rafael Emery
 * @version 1.0
 */

import java.util.Comparator; 
import java.io.Serializable;

@SuppressWarnings("serial")
public class Meta extends ItemAgenda implements Comparable<ItemAgenda>, Serializable {
	private int prioridade;

	//Metodos construtores
	/**
	 * Construtor vazio para o objeto
	 * @throws Exception caso o objeto seja vazio
	 */
	public Meta() throws Exception {
		super();
	}
	/**
	 * Inicializa uma inst�ncia de Lembrete
	 * @param _titulo t�tulo do �tem
	 * @param _descricao descri��o do �tem
	 * @param _periodo per�odo que ocorrer� a meta
	 * @param _prioridade n�vel de prioridade da meta (de 1 a ...) 
	 * @throws Exception caso os par�metros sejam inv�lidos
	 */
	public Meta(String _titulo, String _descricao, Periodo _periodo, int _prioridade) throws Exception {
		super(_titulo, _descricao, _periodo);
		this.prioridade = _prioridade;
	}
	
	//Metodo set
	/**
	 * Insere e verifica a prioridade da meta
	 * @param _prioridade inteiro para a prioridade (de 1 a ...)
	 * @throws Exception caso a prioridade seja inv�lida (0 ou negativa)
	 */
	public void setPrioridade(int _prioridade) throws Exception {
		if (_prioridade <= 1) {
			this.prioridade = _prioridade;
		}
		else {
			throw new Exception("Prioridade invalida.");
		}
	}

	//Metodo get
	public int getPrioridade() {
		return this.prioridade;
	}
	
	//Metodo compareTo
	/**
	 * Compara duas prioridades
	 * @param aux Um objeto do tipo Meta
	 * @return Um inteiro que retorna 1, 0 ou -1
	 */
	public int compareTo(Meta aux) {
		if (this.prioridade > aux.prioridade) {
			return 1;
		}
		else if (this.prioridade == aux.prioridade) {
			return 0;
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
		Meta aux = (Meta) obj;
		if (this.equals(aux) && this.prioridade == aux.prioridade) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Metodo toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\nPrioridade: ");
		builder.append(this.getPrioridade());
		builder.append(". ");
		return builder.toString();
	}
}

/**
 * Classe com a interface Comparator que fornece um m�todo para 
 * ordenar as inst�ncias da classe Meta de acordo com o nivel de 
 * prioridade inserido pelo usu�rio.
 * <p>
 * A ordena��o ser� feita pelo m�todo sort (est�tico) da classe
 * Collections.
 * @author Rafael Emery
 * @version 1.0;
 */
class ComparaPorPrioridade implements Comparator<ItemAgenda> {
	public int compare(ItemAgenda aux1, ItemAgenda aux2) {
		Meta meta1 = (Meta) aux1;
		Meta meta2 = (Meta) aux2;
		int prioridade1 = meta1.getPrioridade();
		int prioridade2 = meta2.getPrioridade();
		if (prioridade1 > prioridade2) {
			return 1;
		}
		else if (prioridade1 == prioridade2) {
			return 0;
		}
		else {
			return -1;
		}
	}
}






