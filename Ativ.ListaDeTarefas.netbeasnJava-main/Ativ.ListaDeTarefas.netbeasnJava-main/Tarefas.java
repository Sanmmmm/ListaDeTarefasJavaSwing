package com.mycompany.todolist.projeto.Tarefas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tarefas extends JFrame {

    public static void add(String novaTarefa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private JTextField campoTarefa;
    private final JButton btnAdicionar;
    private final JButton btnEditar;
    private final JButton btnRemover;
    private final JButton btnLimpar;
    private final JList<String> listaTarefas;
    private DefaultListModel<String> modeloLista;
    private List<String> tarefas = new ArrayList<>();

    public Tarefas() {
        super("Gerenciador de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        campoTarefa = new JTextField(20);
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnRemover = new JButton("Remover");
        btnLimpar = new JButton("Limpar");
        modeloLista = new DefaultListModel<>();
        listaTarefas = new JList<>(modeloLista);

        add(campoTarefa);
        add(btnAdicionar);
        add(btnEditar);
        add(btnRemover);
        add(btnLimpar);
        add(new JScrollPane(listaTarefas));

        // Eventos dos botões
        btnAdicionar.addActionListener(e -> {
    String novaTarefa = campoTarefa.getText();
    if (!novaTarefa.isEmpty()) {
        tarefas.add(novaTarefa);
        modeloLista.addElement(novaTarefa);
        campoTarefa.setText("");
        System.out.println("Tarefa adicionada com sucesso!"); // Mensagem de depuração
    } else {
        System.out.println("Campo de tarefa está vazio.");
    }
});
        btnEditar.addActionListener(e -> {
            editarTarefa();
        });

        btnRemover.addActionListener(e -> {
            removerTarefa();
        });

        btnLimpar.addActionListener(e -> {
            limparLista();
        });

        pack();
        setVisible(true);
    }

    private void editarTarefa() {
        int index = listaTarefas.getSelectedIndex();
        if (index != -1) {
            String tarefaAntiga = tarefas.get(index);
            String novaTarefa = JOptionPane.showInputDialog("Nova tarefa:", tarefaAntiga);
            if (novaTarefa != null && !novaTarefa.isEmpty()) {
                tarefas.set(index, novaTarefa);
                modeloLista.setElementAt(novaTarefa, index);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma tarefa para editar.");
        }
    }

    private void removerTarefa() {
        int index = listaTarefas.getSelectedIndex();
        if (index != -1) {
            tarefas.remove(index);
            modeloLista.remove(index);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma tarefa para remover.");
        }
    }

    private void limparLista() {
        tarefas.clear();
        modeloLista.clear();
    }

    
}