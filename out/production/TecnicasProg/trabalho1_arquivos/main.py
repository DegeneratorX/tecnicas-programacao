from classes import Arquivo, Merge

print("Trabalho Prático 1 - Técnicas de Programação")
print("Aluno:Victor Medeiros Martins - 401339")
print("#*"*15)

str_arquivo_1 = input("Digite o nome do arquivo 1:")
str_arquivo_2 = input("Digite o nome do arquivo 2:")

arquivo_1 = Arquivo(str_arquivo_1)
arquivo_2 = Arquivo(str_arquivo_2)

uniao = Merge(arquivo_1, arquivo_2)
uniao.output_arquivo()
