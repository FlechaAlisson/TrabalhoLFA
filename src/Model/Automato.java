package Model;

import View.View;

import java.util.ArrayList;


public class Automato {
    public void Processa(String fita, ArrayList<Transicoes> list)
    {
        int ant = BuscaTransInicialAnt(list,fita.charAt(0));
        int aux =BuscaTransInicial(list,fita.charAt(0));
        View view = new View();
        view.PrintEstado(0,fita,0);

        int i ;
        for (i = 1; i < fita.length(); i++) {
            ant = aux;
            view.PrintEstado(i,fita,aux);
            aux = BuscaTrans(list, fita.charAt(i), aux);
            if (aux == -1) {
                System.out.println("não aceita");
                return;
            }
        }
        view.PrintFinal(aux);

        if(isFinal(list,aux,fita.charAt(i-1),ant))
              System.out.println("ACEITA");
        else
            System.out.println("NÃO ACEITA");
    }

    private int BuscaTransInicialAnt(ArrayList<Transicoes> list, char c) {
        for (Transicoes t:list) {
            if (t.isIs_inicial())
                if (c == t.getLeitura())
                    return t.getEstado_num();
        }
        return -1;
    }


    public int BuscaTrans(ArrayList<Transicoes>list, char fita, int atual)
    {
        for (Transicoes t:list) {
            if (atual == t.getEstado_num())
                if (fita == t.getLeitura())
                    return t.getProx();
        }
        return -1;
    }
    public int BuscaTransInicial(ArrayList<Transicoes>list, char fita)
    {
        for (Transicoes t:list) {
            if (t.isIs_inicial())
                if (fita == t.getLeitura())
                    return t.getProx();
        }
        return -1;
    }
    public boolean isFinal(ArrayList<Transicoes> list, int atual, char fita, int ant)
    {

        for (Transicoes t:list) {

            if (t.getEstado_num() == atual ) {
                if ( BuscaLidoAnt(list,ant,fita)) {
                    return t.isIs_final();
                }
            }
        }
        return false;
    }
    public boolean BuscaLidoAnt(ArrayList<Transicoes> list, int atual, char c)
    {
        for (Transicoes t:list  ) {
            if (t.getEstado_num() == atual)
                if (t.getLeitura() == c)
                    return true;
        }
        return false;
    }


    public void GeraLing(ArrayList<Transicoes> list) {
       int i = 0;
        while (!list.isEmpty()){
            ArrayList<Transicoes> aux = BuscaIguais(list,i);
            if (aux == null)
                return;
            ImprimeLinguagem(aux);
            RemoveTransdaLista(list, aux);

            System.out.println();
            i++;

        }

    }

    //imprime a linha da linguagem
    private void ImprimeLinguagem(ArrayList<Transicoes> aux) {
        if (aux == null || aux.isEmpty())
            return;
        Transicoes t = aux.get(0);
        char prox = (char) (t.getProx() + 'A' -1);

        if(t.isIs_inicial()){
            System.out.print("S -> ");
            System.out.print(t.getLeitura());
            System.out.print(prox);
        }else{
            char letra = (char) (t.getEstado_num()-1+'A' );
            System.out.print(letra + " -> ");
            System.out.print(t.getLeitura());
            System.out.print(prox);
        }
        aux.remove(aux.get(0));
        if(!aux.isEmpty()) {
            for (Transicoes trans :aux ) {
                System.out.print(" | ");
                ImprimeLeitura(trans);
            }
        }
        if (t.isIs_final())
        {
            System.out.print(" | @");
        }

    }

    private void ImprimeLeitura(Transicoes t) {
        char prox = (char) (t.getProx() + 'A' -1);
        System.out.print(t.getLeitura());
        System.out.print(prox);
    }

    //retira todos os elementos iguais da list1
    public void RemoveTransdaLista(ArrayList<Transicoes> list1, ArrayList<Transicoes> list2)
    {
        for (Transicoes t:list2
             ) {list1.remove(t);

        }
    }

    private ArrayList<Transicoes> BuscaIguais(ArrayList<Transicoes> list, int estado_num) {
        if(estado_num > list.size())
            return null;
        ArrayList<Transicoes> listiguais = new ArrayList<>();
        for (Transicoes t: list
             ) {
            if(t.getEstado_num() == estado_num)
                listiguais.add(t);

        }
        return  listiguais;
    }

}
