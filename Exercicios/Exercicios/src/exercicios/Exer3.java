/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicios;
import exemplo.Pilha;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafaela
 */
public class Exer3 {

    // método que converte número decimal para binário usando pilha
    public static String converterParaBinario(int numero) {
        Pilha pilha = new Pilha(32); // Cria uma pilha com espaço suficiente

        // se o número for zero
        if (numero == 0) {
            return "0";
        }

        //divide o número por 2 até chegar em 0, empilhando os restos
        while (numero > 0) {
            int resto = numero % 2;
            pilha.empilhar(resto); // empilha o resto
            numero = numero / 2;   // atualiza o número
        }

        // desempilha tudo e monta a string binária
        String binario = "";
        while (!pilha.vazia()) {
            binario += pilha.desempilhar().toString();
        }

        return binario;
    }

    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog("Digite um número decimal:");

        try {
            int numero = Integer.parseInt(entrada); 
            String binario = converterParaBinario(numero); 

            JOptionPane.showMessageDialog(null,
                    "Número decimal: " + numero + "\nNúmero binário: " + binario);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um número inteiro válido.");
        }
    }
}
