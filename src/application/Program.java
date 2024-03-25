package application;

import entities.TaxPayer;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        TaxPayer taxPayer;

        double salaryIncome = 0;
        double servicesIncome = 0;
        double capitalIncome = 0;
        double healthSpending = 0;
        double educationSpending = 0;

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int number = sc.nextInt();
        int[] vect = new int[number];

        for (int i = 1; i <= vect.length; i++) {

            System.out.println();
            System.out.println("Digite os dados do " + i + "o contribuinte:");

            System.out.print("Renda anual com salário: ");
            salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            educationSpending = sc.nextDouble();

            System.out.println();
            taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
            list.add(taxPayer);

            taxPayer.salaryTax();
            taxPayer.servicesTax();
            taxPayer.capitalTax();

        }

            for (TaxPayer elemento : list) {

                for (int i = 0; i < list.size() ; i++) {
                    elemento = list.get(i);


                    System.out.println();
                    System.out.println("Resumo do " + (i + 1) + " contribuinte:");

                    System.out.printf("Imposto bruto total: %.2f%n", elemento.grossTax());
                    System.out.printf("Abatimento: %.2f%n", elemento.taxRebate());
                    System.out.printf("Imposto devido: %.2f%n", elemento.netTax());

                }
        }

        sc.close();

    }
}