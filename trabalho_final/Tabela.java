package trabalho_final;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/** 
* Classe usada para ler o arquivo contendo a tabela de dados, alterar
* os dados dessa tabela e alterar seus dados.
*
* @author Guilherme Gomes Botelho
*/
public class Tabela 
{
  /** 
  * Vetor que contém o nome de todas as colunas. 
  */
  private String nomes_colunas[];
  /** 
  * Matriz que contém os dados da tabela, onde o primeiro parâmetro
  * ([]) representa a linha e o segundo a coluna onde um determindado   * dado se encontra.
  */
  private String dados[][];
  /** 
  * Cria uma nova instância de Tabela e chama o método lerArquivo.
  *
  * @param arq Um arquivo contendo uma tabela de dados
  * @throws FileNotFoundException Se o arquivo não for encontrado 
  */
  public Tabela(File arq) throws FileNotFoundException
  {
    lerArquivo(arq);
  }
  /** 
  * Percorre um arquivo contendo uma tabela de dados. Primeiramente,
  * inserindo os nomes das colunas no vetor nomes_colunas[] e, em 
  * seguida, inserindo os dados na matriz dados[][].
  * 
  * @param arq Um arquivo contendo uma tabela de dados
  * @throws FileNotFoundException Se o arquivo não for encontrado 
  */
  private void lerArquivo(File arq) throws FileNotFoundException
  {
    FileInputStream arquivo_tab = new FileInputStream(arq);
    Scanner lerTabela = new Scanner(arquivo_tab);
    
    String linha = lerTabela.nextLine();
    nomes_colunas = linha.split("\\,");
    int i = 0, j;
    dados = new String[nomes_colunas.length][nomes_colunas.length];
    while(lerTabela.hasNext())
    {
      linha = lerTabela.nextLine();
      String linha_dados[] = linha.split("\\,");
      for(j = 0; j < linha_dados.length; j++)
      {
        dados[i][j] = linha_dados[j]; 
      }
      i++;
    }
    lerTabela.close();
  }
  /**
  * Retorna o nome de uma determinada coluna.
  *
  * @param coluna Inteiro que representa o posição ordinal da coluna
  * @return O nome da coluna requerida
  */
  public String getNomeColuna(int coluna) 
  {
    return nomes_colunas[coluna];
  }
  /**
  * Retorna o dado de uma determinada posição da matriz de dados.
  *
  * @param linha Inteiro que representa a posição ordinal da linha
  * @param coluna Inteiro que representa o posição ordinal da coluna
  * @return O dado requerido em forma de String
  */
  public String getDadoUnico(int linha, int coluna) 
  {
    return dados[linha][coluna];
  }
  /**
  * Altera o dado de um local específico da matriz de dados.
  *
  * @param linha Inteiro que representa o número da linha do dado que deseja-se alterar
  * @param coluna Inteiro que representa o número da coluna do dado que deseja-se alterar
  * @param novo String que irá substituir o dado antigo
  */
  public void alterarDado(int linha, int coluna, String novo)
  {
    dados[linha][coluna] = novo;
  }
  /**
  * Ainda não sei se vamos usar essa função, se sim, eu comento ela depois.
  */
  public void imprimirTabela() 
  {  
    int i, j;
    for(i = 0; i < nomes_colunas.length; i++)
    {
      System.out.printf("%s|", nomes_colunas[i]);
    }
    System.out.println("\n");
    for (i = 0; i < nomes_colunas.length; i++) 
    {
      System.out.print("|");
      for (j = 0; j < dados.length; j++)
      {
        System.out.printf("%s|", dados[i][j]);
      }
      System.out.println("\n");
    }
  }
  /**
  * Recebe uma Tabela e escreve todas as suas informações em um
  * novo arquivo chamado "arquivoFinal.txt".
  *
  * @param tabela Uma tabela com um vetor de nome e uma matriz de dados
  * @throws IOException Se houver um erro na escrita do arquivo
  */
  public void CriarNovoArquivo(Tabela tabela)
  {
    int i, j;
    File arquivoFinal = new File("arquivoFinal.txt");
    try
    {
      FileWriter writer = new FileWriter(arquivoFinal);
      PrintWriter print = new PrintWriter(writer);
      for(i = 0; i < tabela.nomes_colunas.length; i++)
      {
        print.printf("%s", tabela.nomes_colunas[i]);
        if(i < tabela.nomes_colunas.length - 1)
        {
          print.print(",");
        }
      }
      print.print("\n");
      for (i = 0; i < tabela.dados.length; i++) 
      {
        for (j = 0; j < tabela.dados.length; j++)
        {
          print.printf("%s", dados[i][j]);
          if(j < tabela.nomes_colunas.length - 1)
          {
            print.print(",");
          }
        }
        print.print("\n");
      }
      print.close();
      writer.close();
    }
    catch(IOException e)
    {
      System.out.println("Erro na escrita do arquivo");
    }
  }
}