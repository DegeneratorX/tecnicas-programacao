package trabalho_final; /**
* esse arquivo não vai estar no arquivo final, ele é apenas para
* criarmos tabelas diferentes e testarmos o cógido 
*/
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorTabelas {

    public static void main(String[] args) {
        String[] colunas = {"Coluna 1", "Coluna 2", "Coluna 3", "Coluna 4", "Coluna 5",
                            "Coluna 6", "Coluna 7", "Coluna 8", "Coluna 9", "Coluna 10"};

        String[] tiposDados = {"int", "float", "string"};

        try {
            FileWriter arquivo = new FileWriter("tabela_dados.txt");

            // Escreve os nomes das colunas na primeira linha
            for (int i = 0; i < colunas.length; i++) {
                arquivo.write(colunas[i]);
                if (i < colunas.length - 1) {
                    arquivo.write(",");
                }
            }
            arquivo.write("\n");

            // Preenche a tabela com os dados aleatórios
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    String tipoDado = tiposDados[j % tiposDados.length];

                    if (tipoDado.equals("int")) {
                        int dado = random.nextInt(100);
                        arquivo.write(String.valueOf(dado));
                    } else if (tipoDado.equals("float")) {
                        float dado = Math.round(random.nextFloat() * 1000) / 1000f;
                        arquivo.write(String.valueOf(dado));
                    } else {
                        StringBuilder dado = new StringBuilder();
                        for (int k = 0; k < 5; k++) {
                            char c = (char) (random.nextInt(26) + 'a');
                            dado.append(c);
                        }
                        arquivo.write(dado.toString());
                    }

                    if (j < 9) {
                        arquivo.write(",");
                    }
                }
                arquivo.write("\n");
            }

            arquivo.close();
            System.out.println("Arquivo gerado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

