// Aluno: Victor Medeiros Martins
// Matrícula: 401339

// Pacote da minha pasta
package trabalho2_decorator;

// Interface
interface Mesa {
    String decorar();
}


// Classe concreta que implementa a interface
class MesaSimples implements Mesa {
    @Override
    public String decorar() {
        return "Mesa simples";
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
        return super.decorar() + "e com rodas";
    }
}


// Decorator concreto para adicionar toalha
class MesaComToalha extends Decorator {
    public MesaComToalha(Mesa mesaDecorada) {
        super(mesaDecorada);
    }

    @Override
    public String decorar() {
        return super.decorar() + "e com toalha";
    }
}


// Decorator concreto para adicionar rede de ping-pong
class MesaComRedePingPong extends Decorator {
    public MesaComRedePingPong(Mesa mesaDecorada) {
        super(mesaDecorada);
    }

    @Override
    public String decorar() {
        return super.decorar() + "e com rede de ping-pong";
    }
}

public class Main {
    public static void main(String[] args) {
        // Cria uma mesa simples inicial, que vai servir de base para decoração
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

        
        // Decoro novamente com rede de ping-pong para mostrar que o padrão tá
        // funcionando e que ele sempre decorará, mesmo que repetidamente
        mesa = new MesaComRedePingPong(mesa);
        System.out.println(mesa.decorar());
    }
}