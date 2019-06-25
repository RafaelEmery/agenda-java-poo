package agendaPrincipal;

/**
 * Encapsula um tipo de ItemAgenda chamado Lembrete.
 * <p>
 * Um lembrete � um �tem da agenda que possui como diferencial
 * a quantidade de minutos de anteced�ncia que o aviso deve
 * ter.
 * <p>
 * A classe abaixo possui m�todos construtores, setters e getters,
 * equals e outros para a manipula��o de itens de agenda do tipo
 * Lembrete. Al�m disso implementa a interface Comparable para fazer 
 * a ordena��o e a Serializable para a grava��o em arquivo.
 * @author Rafael Emery
 * @version 1.0
 */

import java.util.Comparator;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Lembrete extends ItemAgenda implements Comparable<ItemAgenda>, Serializable {
	private int qtdeMinAlerta;

	//Metodos construtores
	/**
	 * Construtor vazio para o objeto
	 * @throws Exception caso o objeto seja vazio
	 */
	public Lembrete() throws Exception {
		super();
	}
	/**
	 * Inicializa uma inst�ncia de Lembrete
	 * @param _titulo t�tulo do �tem
	 * @param _descricao descri��o do �tem
	 * @param _periodo per�odo que ocorrer� o lembrete
	 * @param _qtdeMinAlerta quantidade de minutos de anteced�ncia do alerta 
	 * @throws Exception caso os par�metros sejam inv�lidos
	 */
	public Lembrete(String _titulo, String _descricao, Periodo _periodo, int _qtdeMinAlerta) throws Exception {
		super(_titulo, _descricao, _periodo);
		this.setQtdeMinAlerta(_qtdeMinAlerta);
	}
	
	//Metodo set
	/**
	 * Insere e verifica a quantidade de minutos inserida
	 * @param _qtdeMinAlerta A quantidade de minutos de anteced�ncia que o alerta deve ter
	 * @throws Exception Caso os minutos sejam inv�lidos (negativos)
	 */
	public void setQtdeMinAlerta(int _qtdeMinAlerta) throws Exception {
		if (qtdeMinAlerta >= 0) {
			this.qtdeMinAlerta = _qtdeMinAlerta;
		}
		else {
			throw new Exception("Alerta invalido.");
		}
	}
	
	//Metodo get
	public int getQtdeMinAlerta() {
		return qtdeMinAlerta;
	}
	
	//Metodo compareTo
	/**
	 * Compara duas quantidades de minutos
	 * @param aux Um objeto do tipo Lembrete
	 * @return Um inteiro que retorna 1, 0 ou -1
	 */
	public int compareTo(Lembrete aux) {
		if (this.qtdeMinAlerta > aux.qtdeMinAlerta) {
			return 1;
		}
		else if (this.qtdeMinAlerta == aux.qtdeMinAlerta) {
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
		Lembrete aux = (Lembrete) obj;
		if (this.equals(aux) && this.getQtdeMinAlerta() == aux.getQtdeMinAlerta()) {
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
		builder.append("\nQuantidade de minutos de antecedencia: ");
		builder.append(this.getQtdeMinAlerta());
		builder.append(". ");
		return builder.toString();
	}
}

/**
 * Classe com a interface Comparator que fornece um m�todo para 
 * ordenar as inst�ncias da classe Lembrete de acordo com a
 * quantidade de minutos de anteced�ncia do alerta.
 * <p>
 * A ordena��o ser� feita pelo m�todo sort (est�tico) da classe
 * Collections.
 * @author Rafael Emery
 * @version 1.0;
 */
class ComparaPorQtdeMinutos implements Comparator<ItemAgenda> {
	public int compare(ItemAgenda aux1, ItemAgenda aux2) {
		Lembrete lembrete1 = (Lembrete) aux1;
		Lembrete lembrete2 = (Lembrete) aux2;
		int qtde1 = lembrete1.getQtdeMinAlerta();
		int qtde2 = lembrete2.getQtdeMinAlerta();
		if (qtde1 > qtde2) {
			return 1;
		}
		else if (qtde1 == qtde2) {
			return 0;
		}
		else {
			return -1;
		}
	}
}
