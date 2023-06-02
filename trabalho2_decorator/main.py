# Interface Componente
class Mesa:
    def decorar(self):
        pass

<<<<<<< HEAD

=======
>>>>>>> f3ba5cb (Ola)
# Classe concreta que implementa a interface Componente
class MesaBasica(Mesa):
    def decorar(self):
        return "Mesa básica"

<<<<<<< HEAD

=======
>>>>>>> f3ba5cb (Ola)
# Decorator abstrato que implementa a interface Componente
class Decorator(Mesa):
    def __init__(self, mesa_decorada):
        self.mesa_decorada = mesa_decorada

    def decorar(self):
        return self.mesa_decorada.decorar()

<<<<<<< HEAD

=======
>>>>>>> f3ba5cb (Ola)
# Decorator concreto para adicionar rodas
class MesaComRodas(Decorator):
    def decorar(self):
        return super().decorar() + ", com rodas"

<<<<<<< HEAD

=======
>>>>>>> f3ba5cb (Ola)
# Decorator concreto para adicionar toalha
class MesaComToalha(Decorator):
    def decorar(self):
        return super().decorar() + ", com toalha"

<<<<<<< HEAD

=======
>>>>>>> f3ba5cb (Ola)
# Decorator concreto para adicionar rede de ping-pong
class MesaComRedePingPong(Decorator):
    def decorar(self):
        return super().decorar() + ", com rede de ping-pong"

<<<<<<< HEAD

=======
>>>>>>> f3ba5cb (Ola)
# Exemplo de uso
if __name__ == "__main__":
    # Cria uma mesa básica
    mesa = MesaBasica()
    print(mesa.decorar())

    # Decora a mesa com rodas
    mesa = MesaComRodas(mesa)
    print(mesa.decorar())

    # Decora a mesa com toalha
    mesa = MesaComToalha(mesa)
    print(mesa.decorar())

    # Decora a mesa com rede de ping-pong
    mesa = MesaComRedePingPong(mesa)
<<<<<<< HEAD
    print(mesa.decorar())
=======
    print(mesa.decorar())
>>>>>>> f3ba5cb (Ola)
