package util;

import Model.Transicoes;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public ArrayList<Transicoes> CarregarArquivo() throws IOException {
        FileInputStream file = new FileInputStream("automato.txt");

        InputStreamReader reader = new InputStreamReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String linha = new String();
        for(int i = 0; i < 2; i++) {
            bufferedReader.readLine();
        }

        linha = bufferedReader.readLine();
        char aux = linha.charAt(9);
        int inicial = Character.getNumericValue(aux);
        ArrayList<Integer> finais = trataFinais( bufferedReader.readLine());



        ArrayList<Transicoes> list = new ArrayList<>();
        linha = bufferedReader.readLine();
        list.add(trataEstado(linha,inicial,finais));
        while (linha != null)
        {
            list.add(trataEstado(linha,inicial,finais));
            linha = bufferedReader.readLine();


        }
        bufferedReader.close();
        list.remove(list.get(0));
        return list;
    }

    private ArrayList<Integer> trataFinais(String s) {
        ArrayList<Integer> list = new ArrayList<>();

        char aux = 0;
        int i = 0;
        for (i = 9;i < s.length() ; i += 3 )
        {
            aux = s.charAt(i);
            if (aux != -1){
                list.add(Character.getNumericValue(aux));
            }

        }
        return list;
    }

    public Transicoes trataEstado(String linha, int inicial, ArrayList<Integer> finais)
    {
        if(linha == null)
        {
            return null;
        }
        Transicoes transicoes = new Transicoes();
        int i = Character.getNumericValue(linha.charAt(2));
        transicoes.setEstado_num(i);
        transicoes.setLeitura(linha.charAt(4));
        i = Character.getNumericValue(linha.charAt(9));
        transicoes.setProx(i);

        if (transicoes.getEstado_num() == inicial)
            transicoes.setIs_inicial(true);
        if(finais.contains(transicoes.getEstado_num()))
            transicoes.setIs_final(true);

        return transicoes;

    }
}
