/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicios;

import exemplo.Pilha;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafaela
 */
public class Exer2 {

    public static void main(String[] args) {
        String expressao = JOptionPane.showInputDialog("Digite a expressão ((), {}, []):");

        if (expressao == null || expressao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Expressão vazia!");
            return;
        }

        boolean balanceada = verificarExpressaoBalanceada(expressao);

        if (balanceada) {
            JOptionPane.showMessageDialog(null, "Expressão VÁLIDA: os símbolos estão balanceados.");
        } else {
            JOptionPane.showMessageDialog(null, "Expressão INVÁLIDA: os símbolos não estão balanceados.");
        }
    }

    public static boolean verificarExpressaoBalanceada(String expressao) {
        Pilha pilha = new Pilha(expressao.length());

        for (int i = 0; i < expressao.length(); i++) {
            char simbolo = expressao.charAt(i);

            if (simbolo == '(' || simbolo == '[' || simbolo == '{') {
                pilha.empilhar(simbolo);
            } else if (simbolo == ')' || simbolo == ']' || simbolo == '}') {
                if (pilha.vazia()) {
                    return false;
                }

                char topo = (char) pilha.desempilhar();
                if (!simbolosCorrespondem(topo, simbolo)) {
                    return false;
                }
            }
        }

        return pilha.vazia();
    }

    public static boolean simbolosCorrespondem(char abre, char fecha) {
        return (abre == '(' && fecha == ')') ||
               (abre == '[' && fecha == ']') ||
               (abre == '{' && fecha == '}');
    }
}
