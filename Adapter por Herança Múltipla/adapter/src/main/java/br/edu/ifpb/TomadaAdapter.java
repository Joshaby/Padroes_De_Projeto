package br.edu.ifpb;

import com.katyusco.padroes.adpater.servicos.*;

public class TomadaAdapter extends ServicoTomada3Pinos implements Tomada2Pinos_IF {

    public TomadaAdapter(Fio fase, Fio neutro) {
        super(fase, neutro, Fio.TERRA);
    }
}
