# Interface Componente
class Mesa:
    def decorar(self):
        pass


# Classe concreta que implementa a interface Componente
class MesaBasica(Mesa):
    def decorar(self):
        return "Mesa básica"


# Decorator abstrato que implementa a interface Componente
class Decorator(Mesa):
    def __init__(self, mesa_decorada):
        self.mesa_decorada = mesa_decorada

    def decorar(self):
        return self.mesa_decorada.decorar()


# Decorator concreto para adicionar rodas
class MesaComRodas(Decorator):
    def decorar(self):
        return super().decorar() + ", com rodas"


# Decorator concreto para adicionar toalha
class MesaComToalha(Decorator):
    def decorar(self):
        return super().decorar() + ", com toalha"


# Decorator concreto para adicionar rede de ping-pong
class MesaComRedePingPong(Decorator):
    def decorar(self):
        return super().decorar() + ", com rede de ping-pong"


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
    print(mesa.decorar())
