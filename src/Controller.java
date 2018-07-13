import Model.Automato;
import Model.Transicoes;
import util.Arquivo;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) throws IOException {
        Arquivo arquivo = new Arquivo();
        ArrayList<Transicoes> list = arquivo.CarregarArquivo();
        Automato automato = new Automato();
        System.out.println("PROCESSAMENTO:");
        automato.Processa("ab00cb",list);
        System.out.println();
        System.out.println("LINGUAGEM:");
        automato.GeraLing(list);

    }
}
