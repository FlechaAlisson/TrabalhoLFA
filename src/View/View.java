package View;

public class View {
    public void PrintEstado(int i, String s, int atual)
    {
        System.out.print("q["+atual+"]");
        for (;i<s.length();i++)
            System.out.print(s.charAt(i));
        System.out.println("");
    }

    public void PrintFinal(int aux) {
        System.out.println("q["+aux+"]");
    }
}
