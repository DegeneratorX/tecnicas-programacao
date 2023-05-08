import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Trabalho Prático 1 - Técnicas de Programação");
        System.out.println("Aluno: Victor Medeiros Martins - 401339");
        for (int i = 0; i < 15; i++) {
            System.out.print("#");
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo 1:");
        String str_arquivo_1 = scanner.nextLine();
        System.out.print("Digite o nome do arquivo 2:");
        String str_arquivo_2 = scanner.nextLine();
        str_arquivo_1.substring(0, 0)
        Arquivo arquivo_1 = new Arquivo(str_arquivo_1);
        Arquivo arquivo_2 = new Arquivo(str_arquivo_2);

        Merge uniao = new Merge(arquivo_1, arquivo_2);
        uniao.output_arquivo();
        scanner.close();
    }
}
