package jogodavelha;

import javax.swing.JFrame;

/**
 *
 * @author joao
 */
public class JogoDaVelha {
    public static void main(String[] args) {
        JJogoDaVelha jogo = new JJogoDaVelha();
	jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//evento de close
        jogo.setLocationRelativeTo(null);//Abrindo Centro da tela
	jogo.setVisible(true);
    }
    
}
