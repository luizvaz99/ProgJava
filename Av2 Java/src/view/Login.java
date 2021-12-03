import javax.swing.*;

import java.awt.*;

public class Login{

    private JFrame janela;
    private JPanel painel;

    // componentes da janela
    private JLabel lblTitulo;
    private JLabel lbluser;
    private JLabel lblpass;

    private JTextField txtuser;
    private JTextField txtpass;

    private JButton btnSubmit;


    public Login() {
        janela = new JFrame("Login");

        painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50));
        painel.setLayout(new GridLayout(0, 1));

        // desenhar tela
        lblTitulo = new JLabel("Acesse sua conta");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        painel.add(lblTitulo);

        lbluser = new JLabel("Login");
        painel.add(lbluser);
        txtuser = new JTextField("user@mail.com");
        painel.add(txtuser);

        lblpass = new JLabel("Senha");
        painel.add(lblpass);
        txtpass = new JTextField("**********");
        painel.add(txtpass);

        btnSubmit = new JButton("Enviar");
        painel.add(btnSubmit);

        janela.add(painel, BorderLayout.CENTER);
        janela.setSize(600, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

   

    public static void main(String[] args) {
        new Login();
    }
}