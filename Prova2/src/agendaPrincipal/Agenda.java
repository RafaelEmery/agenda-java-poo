package agendaPrincipal;

/**
 * Encapsula uma agenda com m�todos para inserir e 
 * manipular elementos.
 * <p>
 * Possui uma cole��o do tipo LinkedList para trabalhar com
 * a agenda e seus respectivos m�todos de inser��o e manipula��o.
 * Al�m disso, possui a interface Serializable para gravar e 
 * recuperar a agenda em disco.
 * @author Rafael Emery
 * @version 1.0
 */

import java.util.*;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

@SuppressWarnings("serial")
public class Agenda implements Serializable {

	private List<ItemAgenda> agenda = new LinkedList<ItemAgenda>();
		
	//Metodos sobrecarregados para inserir
	/**
	 * Inserindo um �tem do tipo Evento
	 * @param evento inst�ncia de Evento
	 * @throws Exception caso o evento seja inv�lido
	 */
	public void insere(Evento evento) throws Exception {
		agenda.add(evento);
	}
	/**
	 * Inserindo um �tem do tipo Lembrete
	 * @param lembrete inst�ncia de Lembrete
	 * @throws Exception caso o lembrete seja inv�lido
	 */
	public void insere(Lembrete lembrete) throws Exception  {
		agenda.add(lembrete);
	}
	/**
	 * Inserindo um �tem do tipo Meta
	 * @param meta inst�ncia de Meta
	 * @throws Exception caso o evento seja inv�lido
	 */
	public void insere(Meta meta) throws Exception  {
		agenda.add(meta);
	}

	//Metodos get
	/**
	 * Consegue a lista
	 * @return retorna a Collection de agenda
	 */
	public List<ItemAgenda> getAgenda() {
		return this.agenda;
	}
	
	//Metodos para ordenar a agenda
	/**
	 * Ordena por prioridade da meta com o comparador definido na
	 * classe Meta
	 * <p>
	 * Exibe somente os meta ordenados pelo m�todo sort
	 */
	public void ordenaPorPrioridade() {
		Collections.sort(this.agenda, new ComparaPorPrioridade());
		StringBuilder m = new StringBuilder();
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if (this.getAgenda().get(i).getClass() == Meta.class) {
				m.append(this.getAgenda().get(i));
			}
		}
		System.out.println(m.toString());
	}
	/**
	 * Ordena por quantidade de minutos do lembrete com o comparador definido na
	 * classe Lembrete
	 * <p>
	 * Exibe somente os lembretes ordenados pelo m�todo sort
	 */
	public void ordenaPorQtdeMinutos() {
		Collections.sort(this.agenda, new ComparaPorQtdeMinutos());
		StringBuilder l = new StringBuilder();
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if (this.getAgenda().get(i).getClass() == Lembrete.class) {
				l.append(this.getAgenda().get(i));
			}
		}
		System.out.println(l.toString());
	}
	/**
	 * Ordena pelo local do evento com o comparador definido na
	 * classe Evento
	 */
	public void ordenaPorLocal() {
		Collections.sort(this.agenda, new ComparaPorLocal());
		StringBuilder e = new StringBuilder();
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if (this.getAgenda().get(i).getClass() == Evento.class) {
				e.append(this.getAgenda().get(i));
			}
		}
		System.out.println(e.toString());
	}
	
	//Metodo exibir itens em um determinado intervalo de datas
	/**
	 * Exibe os �tem da agenda em um determinado intervalo de datas
	 * @param dt1 data inicial do per�odo escolhido
	 * @param dt2 data final do per�odo escolhido
	 * @return uma inst�ncia de objeto StringBuilder com o toString(),
	 * imprimindo diretamente os dados selecionados/adicionados.
	 * @throws Exception caso o intervalo de datas seja inv�lido (datas de
	 * inicio e final incoerentes).
	 */
	public String itensIntervalo(Data dt1, Data dt2) throws Exception {
		if (dt1.compareTo(dt2) <= 0) {
			StringBuilder intervalo = new StringBuilder();
			for (int i = 0; i < this.agenda.size(); i++) {
				if ((agenda.get(i).getPeriodo().getDataInicio().compareTo(dt1) >= 0) && 
						(agenda.get(i).getPeriodo().getDataInicio().compareTo(dt2)) <= 0) {
					intervalo.append(agenda.get(i));
				}
			}
			return intervalo.toString();
		}
		else {
			throw new Exception("Intervalo invalido!");
		}
	}
	
	//Gravando a agenda em um arquivo
	/**
	 * Criando um arquivo e escrevendo a agenda nesse arquivo
	 * @param nomeArquivo nome do arquivo que ser� gerado
	 * @param agenda inst�ncia de agenda que ser� gravada
	 * @throws FileNotFoundException caso n�o encontre o arquivo
	 * @throws IOException problema na cria��o ou grava��o do arquivo
	 */
	public static void gravaAgenda(String nomeArquivo, Object agenda) throws FileNotFoundException, IOException {
		ObjectOutputStream arquivo = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
		arquivo.writeObject(agenda);
		arquivo.flush();
		arquivo.close();
	}

	//Le o arquivo gravado
	/**
	 * Le o arquivo gravado (e ser� imprimido na classe Uso)
	 * @param nomeArquivo nome do arquivo que ser� buscado e lido
	 * @return retorna um objeto do tipo Agenda que ser� lido 
	 * @throws FileNotFoundException caso n�o encontre o arquivo
	 * @throws IOException problema na leitura do arquivo
	 * @throws ClassNotFoundException problema no casting do arquivo lido
	 * (caso Agenda n�o exista, por exemplo)
	 */
	public static Agenda leAgenda(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream arquivo = new ObjectInputStream(new FileInputStream(nomeArquivo));
		Agenda agenda = (Agenda) arquivo.readObject();
		arquivo.close();
		return agenda;
	}
	
	//Metodo toString
	/**
	 * M�todo toString personalizado para a impress�o ser de 
	 * melhor visualiza��o no console.
	 * <p>
	 * Ir� imprimir basicamente o tipo do �tem e o elemento em
	 * quest�o.
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		System.out.println("Numero de itens: " + agenda.size());
		for (int i = 0; i < this.getAgenda().size(); i++) {
			builder.append("\nTipo: " + agenda.get(i).getClass());
			builder.append(agenda.get(i));
		}
		return builder.toString();
	}	
}