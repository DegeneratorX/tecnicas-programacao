import java.awt.*;

public class Janela extends Frame {
    Janela(String titulo){
        super(titulo);
        this.setSize(500,500);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] a){
        Janela j = new Janela("Teste janela");
        Button b = new Button("Teste");

        b.setForeground((Color.blue));
        b.setBackground((Color.red));
        b.setLocation(100,100);
        b.setSize(50,50);
        j.add(b, "North");

        Panel p = new Panel();
        p.setBackground(Color.red);
        j.add(p);

        Label l = new Label("Login");
        l.setForeground(Color.blue);
    }
}

