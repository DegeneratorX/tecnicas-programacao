package trabalho_final;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class Main 
{
  public static void main(String[] args) throws FileNotFoundException
  {
    File arq = new File("arquivo.txt");
    LerArquivo arquivoTabela = new LerArquivo(arq);
    arquivoTabela.CriarNovoArquivo(arquivoTabela);
    String teste = arquivoTabela.getDadoUnico(0, 0);
    System.out.printf("%s\n", teste);
  }
}