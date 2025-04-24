/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicios;
import exemplo.FilaString;
import javax.swing.JOptionPane;
/**
 *
 * @author Rafaela
 */
public class FilaAtendimento {
    FilaString filaAlta;
    FilaString filaNormal;
    private int contadorAlta = 0;

    public FilaAtendimento(int tamanho) {
        filaAlta = new FilaString(tamanho);
        filaNormal = new FilaString(tamanho);
    }

    public void adicionarPaciente(String nome, int prioridade) {
        if (prioridade == 1) {
            filaAlta.enfileirar(nome);
            JOptionPane.showMessageDialog(null, "Paciente com PRIORIDADE ALTA adicionado: " + nome);
        } else {
            filaNormal.enfileirar(nome);
            JOptionPane.showMessageDialog(null, "Paciente com PRIORIDADE NORMAL adicionado: " + nome);
        }
    }

    public String chamarProximoPaciente() {
        String paciente;
        if (!filaAlta.vazia() && contadorAlta < 2) {
            paciente = filaAlta.desenfileirar();
            contadorAlta++;
            return "Chamando paciente com PRIORIDADE ALTA: " + paciente;
        } else if (!filaNormal.vazia()) {
            paciente = filaNormal.desenfileirar();
            contadorAlta = 0;
            return "Chamando paciente com PRIORIDADE NORMAL: " + paciente;
        } else if (!filaAlta.vazia()) {
            paciente = filaAlta.desenfileirar();
            return "Chamando paciente com PRIORIDADE ALTA: " + paciente;
        } else {
            return "Nenhum paciente na fila.";
        }
    }

    public static void main(String[] args) {
        FilaAtendimento atendimento = new FilaAtendimento(10);

        for (int i = 0; i < 5; i++) {
            String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
            String prioridadeStr = JOptionPane.showInputDialog("Digite a prioridade (0 - Normal, 1 - Alta):");

            int prioridade;
            try {
                prioridade = Integer.parseInt(prioridadeStr);
                if (prioridade != 0 && prioridade != 1) throw new Exception();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Prioridade inválida! Use 0 ou 1.");
                i--; continue;
            }

            atendimento.adicionarPaciente(nome, prioridade);
        }

        for (int i = 0; i < 6; i++) {
            String proximo = atendimento.chamarProximoPaciente();
            JOptionPane.showMessageDialog(null, proximo);
        }
    }
}
