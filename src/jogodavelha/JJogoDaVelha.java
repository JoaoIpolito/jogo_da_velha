package jogodavelha;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        GridLayout grid = new GridLayout(3, 3, 3, 3);
        container.setLayout(grid);
        for (int i = 0; i < 9; i++) {
            bts.add(new JButton());
            bts.get(i).addActionListener(this);
            container.add(bts.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Posicao; " + bts.indexOf(e.getSource()));
        JButton btn = ((JButton) e.getSource());

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
        return false;
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
        }
    }

}
