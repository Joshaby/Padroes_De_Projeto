/**
 * 
 */
package br.edu.ifpb;

import com.katyusco.padroes.adpater.servicos.Fio;
import com.katyusco.padroes.adpater.servicos.ServicoTomada3Pinos;

/**
 * @author Katyusco
 *
 */
public class ClientePlugParaTomada3Pinos {

	/**
	 * @param args
	 */
	private Fio pinoFase;
	private Fio pinoNeutro;
	private Fio pinoTerra;
	

	public ClientePlugParaTomada3Pinos(Fio pinoFase, Fio pinoNeutro, Fio pinoTerra) {
		this.pinoFase = pinoFase;
		this.pinoNeutro = pinoNeutro;
		this.pinoTerra = pinoTerra;
	}

	private void acoplaPlug() {
		ServicoTomada3Pinos tomada = new ServicoTomada3Pinos(this.pinoFase, this.pinoNeutro, this.pinoTerra);
		tomada.forneceEnergia();	
	}
	
	public static void main(String[] args) {
		ClientePlugParaTomada3Pinos plug3Pinos = new ClientePlugParaTomada3Pinos(Fio.FASE, Fio.NEUTRO, Fio.TERRA);
		plug3Pinos.acoplaPlug();
	}

}
