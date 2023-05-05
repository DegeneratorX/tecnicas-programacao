package trabalho1_arquivos;
import java.util.*;
import java.io.*;

class Arquivo {
    private String str_arquivo;
    private List<String> lista;

    public Arquivo(String str_arquivo) {
        this.str_arquivo = str_arquivo;
        this.lista = this.tratamento_dos_dados();
    }

    public void imprimir_arquivo() {
        System.out.printf("Conteúdo do arquivo %s(%s)%n", this.str_arquivo, this);
        for (int i = 0; i < this.lista.size(); i++) {
            System.out.println(this.lista.get(i));
        }
    }

    private List<String> tratamento_dos_dados() {
        List<String> lista = new ArrayList<>();
        try (BufferedReader arq = new BufferedReader(new FileReader(this.str_arquivo))) {
            String linha;
            while ((linha = arq.readLine()) != null) {
                linha = linha.trim();
                if (linha.contains("\n")) {
                    linha.replace("\n", "");
                }
                lista.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo");
            e.printStackTrace();
        }
        return lista;
    }

    public String getStr_arquivo() {
        return this.str_arquivo;
    }

    public List<String> getLista() {
        return this.lista;
    }

    public void setStr_arquivo(String str_arquivo) {
        this.str_arquivo = str_arquivo;
        this.lista = this.tratamento_dos_dados();
    }
}

class Merge {
    private Arquivo lista1;
    private Arquivo lista2;
    private List<String> lista_total;

    public Merge(Arquivo lista1, Arquivo lista2) {
        this.lista1 = lista1;
        this.lista2 = lista2;
        this.lista_total = this.unir(this.lista1, this.lista2);
    }

    private List<String> unir(Arquivo lista1, Arquivo lista2) {
        List<String> lista_total = new ArrayList<>();
        lista_total.addAll(lista1.getLista());
        lista_total.addAll(lista2.getLista());
        Set<String> set = new HashSet<>(lista_total);
        lista_total.clear();
        lista_total.addAll(set);
        return lista_total;
    }

    public void output_arquivo() {
        try (BufferedWriter file = new BufferedWriter(new FileWriter("arquivo_total.txt"))) {
            for (int i = 0; i < this.lista_total.size(); i++) {
                if (i == this.lista_total.size() - 1) {
                    file.write(this.lista_total.get(i));
                } else {
                    file.write(this.lista_total.get(i) + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo");
            e.printStackTrace();
        }
    }
}