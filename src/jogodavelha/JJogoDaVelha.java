package jogodavelha;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author joao
 */
public class JJogoDaVelha extends JFrame implements ActionListener {

    ArrayList<JButton> bts = new ArrayList<>();
    char vez = 'X';

    public JJogoDaVelha() {
        setTitle("Joga da Velha!!");
        setSize(400, 400);
        Container container = getContentPane();
        GridLayout grid = new GridLayout(3, 3, 10, 10);
        container.setBackground(Color.decode("#17D4C1"));
        container.setLayout(grid);
        for (int i = 0; i < 9; i++) {
            bts.add(novoJButton());
            bts.get(i).addActionListener(this);
            container.add(bts.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Posicao; " + bts.indexOf(e.getSource()));
        JButton btn = ((JButton) e.getSource());

        //Add cor
        btn.setBackground(Color.decode("#28A296"));
        // Prenchendo a posicão
        btn.setText(String.valueOf(vez));
        // Desabilitando a mesma para o usuario não preencher novamente
        btn.setEnabled(false);

        if (verificarSeAlguemGanhou()) {
            JOptionPane.showMessageDialog(rootPane, vez + " ganhou!");
            limpar();
        } else if (verificarSeDeuVelha()) {
            JOptionPane.showMessageDialog(rootPane, "Deu velha");
            limpar();
        } else {
            // Trocando jogador
            if (vez == 'X') {
                vez = 'O';
            } else {
                vez = 'X';
            }
        }
    }

    private boolean verificarSeAlguemGanhou() {
        return preenhidasIguais(0, 1, 2)
                || preenhidasIguais(3, 4, 5)
                || preenhidasIguais(6, 7, 8)
                || preenhidasIguais(0, 3, 6)
                || preenhidasIguais(1, 4, 7)
                || preenhidasIguais(2, 5, 8)
                || preenhidasIguais(0, 4, 8)
                || preenhidasIguais(2, 4, 6);
    }

    private boolean preenhidasIguais(int p1, int p2, int p3) {
        return bts.get(p1).getText().equals("X") && bts.get(p2).getText().equals("X") && bts.get(p3).getText().equals("X")
                || bts.get(p1).getText().equals("O") && bts.get(p2).getText().equals("O") && bts.get(p3).getText().equals("O");
    }

    private boolean verificarSeDeuVelha() {
        for (int i = 0; i < bts.size(); i++) {
            // Se encontrar alguma posição vazia não deu velha
            if (bts.get(i).getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void limpar() {
        for (int i = 0; i < bts.size(); i++) {
            bts.get(i).setText("");
            bts.get(i).setEnabled(true);
            bts.get(i).setBackground(Color.decode("#28A296"));
        }
    }

    private JButton novoJButton() {
        JButton b = new JButton();
        b.setBorderPainted(false);
        b.setBackground(Color.decode("#28A296"));
        b.setFont(new Font("Arial", Font.BOLD, 100));
        return b;
    }

}
