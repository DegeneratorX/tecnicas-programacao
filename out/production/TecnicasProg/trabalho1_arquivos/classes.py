class Arquivo:
    def __init__(self, str_arquivo) -> None:
        self.__str_arquivo = str_arquivo
        self.__lista = self.__tratamento_dos_dados()

    def imprimir_arquivo(self):
        print(f"Conteúdo do arquivo {self.str_arquivo}({self})")
        for i in range(len(self.__lista)):
            print(self.__lista[i])

    def __tratamento_dos_dados(self):
        lista = []
        with open(f"{self.__str_arquivo}", 'r') as arq:
            lista = arq.readlines()
            for i in range(len(lista)):
                lista[i] = lista[i].strip()
                if "\n" in lista[i]:
                    lista[i].replace('\n','')
        return lista
    
    @property
    def str_arquivo(self):
        return self.__str_arquivo
    
    @property
    def lista(self):
        return self.__lista
    
    @str_arquivo.setter
    def str_arquivo(self, str_arquivo):
        self.__str_arquivo = str_arquivo
        self.__lista = self.__tratamento_dos_dados()


class Merge:
    def __init__(self, lista1, lista2) -> None:
        self.__lista1 = lista1
        self.__lista2 = lista2
        self.__lista_total = self.__unir(self.__lista1, self.__lista2)

    @staticmethod
    def __unir(lista1, lista2):
        lista_total = lista1.lista+lista2.lista
        lista_total = set(lista_total)
        lista_total = list(lista_total)
        return lista_total
    
    def output_arquivo(self):
        file = open('arquivo_total.txt', 'w+')
        for i in range(len(self.__lista_total)):
            if i == len(self.__lista_total)-1:
                file.write(f'{self.__lista_total[i]}')
            else:
                file.write(f'{self.__lista_total[i]}\n')

if __name__ == '__main__':
    pass