package Model;

public class Transicoes {
    private int estado_num;
    private char leitura;
    private boolean is_final;
    private boolean is_inicial;
    private int prox;

    public boolean isIs_final() {
        return is_final;
    }

    public boolean isIs_inicial() {
        return is_inicial;
    }

    public void setIs_final(boolean is_final) {
        this.is_final = is_final;
    }



    public void setIs_inicial(boolean is_inicial) {
        this.is_inicial = is_inicial;
    }

    public int getEstado_num() {
        return estado_num;
    }

    public void setEstado_num(int estado_num) {
        this.estado_num = estado_num;
    }

    public char getLeitura() {
        return leitura;
    }

    public void setLeitura(char leitura) {
        this.leitura = leitura;
    }

    public int getProx() {
        return prox;
    }

    public void setProx(int prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "Transicoes{" +
                "estado_num=" + estado_num +
                ", leitura=" + leitura +
                ", is_final=" + is_final +
                ", is_inicial=" + is_inicial +
                ", prox=" + prox +
                '}';
    }
}
