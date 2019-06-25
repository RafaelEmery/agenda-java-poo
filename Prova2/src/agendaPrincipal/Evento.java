package agendaPrincipal;

/**
 * Encapsula um tipo de ItemAgenda chamado Evento.
 * <p>
 * Um evento � um item da agenda que possui como diferencial
 * o local que ir� acontecer.
 * <p>
 * A classe abaixo possui m�todos construtores, setters e getters,
 * equals e outros para a manipula��o de itens de agenda do tipo
 * Evento. Al�m disso implementa a interface Comparable para fazer 
 * a ordena��o e a Serializable para a grava��o em arquivo.
 * @author Rafael Emery
 * @version 1.0
 */

import java.util.Comparator;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Evento extends ItemAgenda implements Comparable<ItemAgenda>, Serializable {
	private String local;
	
	//Metodos construtores
	/**
	 * Construtor vazio para o objeto
	 * @throws Exception caso o objeto seja vazio
	 */
	public Evento() throws Exception {
		super();
	}
	/**
	 * Inicializa uma inst�ncia de Evento
	 * @param _titulo t�tulo do �tem
	 * @param _descricao descri��o do �tem
	 * @param _periodo per�odo que ocorrer� o evento
	 * @param _local local que ir� acontecer o evento
	 * @throws Exception caso os par�metros sejam inv�lidos
	 */
	public Evento(String _titulo, String _descricao, Periodo _periodo, String _local) throws Exception {
		super(_titulo, _descricao, _periodo);
		this.setLocal(_local);
	}
	
	//Metodo set
	/**
	 * Insere o local no objeto
	 * @param _local local que ir� ocorrer o evento
	 * @throws Exception caso o local seja vazio
	 */
	public void setLocal(String _local) throws Exception {
		if (ItemAgenda.isStringValida(_local)) {
			this.local = _local;
		}
		else {
			throw new Exception("Local vazio");
		}
	}
	
	//Metodo get
	public String getLocal() {
		return this.local;
	}
	
	//Metodo compareTo
	/**
	 * Compara dois locais
	 * @param aux Um objeto do tipo Evento
	 * @return Um inteiro que retorna 1, 0 ou -1
	 */
	public int compareTo(Evento aux) {
		return this.getLocal().compareToIgnoreCase(aux.getLocal());
	}
	
	//Metodo equals
	/**
	 * M�todo que verifica se dois objetos s�o iguais e retorna um 
	 * booleano
	 * @param obj Objeto qualquer para se fazer um cast
	 * @return Um booleano que representa se os objetos s�o iguais ou n�o
	 */
	public boolean equals(Object obj) {
		Evento aux = (Evento) obj;
		if (this.equals(aux) && this.local.equalsIgnoreCase(aux.getLocal())) {
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
		builder.append("\nLocal: ");
		builder.append(this.getLocal());
		builder.append(". ");
		return builder.toString();
	}	
}

/**
 * Classe com a interface Comparator que fornece um m�todo para 
 * ordenar as inst�ncias da classe Evento de acordo com o local
 * <p>
 * A ordena��o ser� feita pelo m�todo sort (est�tico) da classe
 * Collections.
 * @author Rafael Emery
 * @version 1.0;
 */
class ComparaPorLocal implements Comparator<ItemAgenda> {
	public int compare(ItemAgenda aux1, ItemAgenda aux2) {
		Evento evento1 = (Evento) aux1;
		Evento evento2 = (Evento) aux2;
		return evento1.getLocal().compareToIgnoreCase(evento2.getLocal());
	}
}
