/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author joao
 */
public class JJogoDaVelha extends JFrame implements ActionListener{

    JButton[] botoes;
    int posicao;

    public JJogoDaVelha() {
        setTitle("Joga da Velha!!");
        setSize(400, 400);
        Container container = getContentPane();
        GridLayout grid = new GridLayout(3, 3, 3, 3);
        container.setLayout(grid);
        botoes = new JButton[9];
        for (int i = 0; i < 9; i++) {
            botoes[i] = new JButton();
        }
        for (posicao = 0; posicao < 9; posicao++) {
            botoes[posicao].addActionListener(this);
        }
        for (int i = 0; i < 9; i++) {
            container.add(botoes[i]);
        }
        super.setLocationRelativeTo(null);//Abrindo Centro da tela
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource().equals(botoes[i])){
                System.out.println("Posicao; " +  i);
            }
        }
    }

}
