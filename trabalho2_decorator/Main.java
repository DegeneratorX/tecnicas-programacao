// Aluno: Victor Medeiros Martins
// Matrícula: 401339

package trabalho2_decorator;

// Interface
interface Mesa {
    String decorar();
}

// Classe concreta que implementa a interface
class MesaSimples implements Mesa {
    @Override
    public String decorar() {
        return "Mesa básica";
    }
}

// Decorator abstrato que implementa a interface
abstract class Decorator implements Mesa {
    protected Mesa mesaDecorada;

    public Decorator(Mesa mesaDecorada) {
        this.mesaDecorada = mesaDecorada;
    }

    public String decorar() {
        return mesaDecorada.decorar();
    }
}

// Decorator concreto para adicionar rodas
class MesaComRodas extends Decorator {
    public MesaComRodas(Mesa mesaDecorada) {
        super(mesaDecorada);
    }

    @Override
    public String decorar() {
        return super.decorar() + ", com rodas";
    }
}

// Decorator concreto para adicionar toalha
class MesaComToalha extends Decorator {
    public MesaComToalha(Mesa mesaDecorada) {
        super(mesaDecorada);
    }

    @Override
    public String decorar() {
        return super.decorar() + ", com toalha";
    }
}

// Decorator concreto para adicionar rede de ping-pong
class MesaComRedePingPong extends Decorator {
    public MesaComRedePingPong(Mesa mesaDecorada) {
        super(mesaDecorada);
    }

    @Override
    public String decorar() {
        return super.decorar() + ", com rede de ping-pong";
    }
}

public class Main {
    public static void main(String[] args) {
        // Cria uma mesa simples
        Mesa mesa = new MesaSimples();
        System.out.println(mesa.decorar());

        // Decora a mesa com rodas
        mesa = new MesaComRodas(mesa);
        System.out.println(mesa.decorar());

        // Decora a mesa com toalha
        mesa = new MesaComToalha(mesa);
        System.out.println(mesa.decorar());

        // Decora a mesa com rede de ping-pong
        mesa = new MesaComRedePingPong(mesa);
        System.out.println(mesa.decorar());
    }
}