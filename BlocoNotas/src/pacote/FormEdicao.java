package pacote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FormEdicao extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static LerEscrever le;
	private JPanel p;
	private JButton btnMostrar, btnSalvar, btnTotln, btnMaisc, btnCaract;
	private JTextArea txtArea; 
	private JLabel texto;
	
	FormEdicao() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Editor de Texto");
		setSize(700, 650);
		p = new JPanel();
		setContentPane(p);
		setLocationRelativeTo(null);
		setLayout(null);
		
		btnMostrar = new JButton("Mostrar dados atuais");
		btnMostrar.setBounds(20, 10, 170, 40);
		p.add(btnMostrar);
		btnMostrar.addActionListener(this);
		
		btnSalvar = new JButton("Salvar Alterações");
		btnSalvar.setBounds(245,10,150,40);
		p.add(btnSalvar);
		btnSalvar.addActionListener(this);
		
		btnTotln = new JButton("Mostrar quantidade de linhas");
		btnTotln.setBounds(450, 10, 200, 40);
		p.add(btnTotln);
		btnTotln.addActionListener(this);
		
		btnMaisc = new JButton("Deixar maiúsculo");
		btnMaisc.setBounds(110, 60, 170, 40);
		p.add(btnMaisc);
		btnMaisc.addActionListener(this);
		
		btnCaract = new JButton("Mostrar quantidade de caracteres");
		btnCaract.setBounds(300, 60, 250, 40);
		p.add(btnCaract);
		btnCaract.addActionListener(this);
		
		txtArea = new JTextArea("");
		txtArea.setBounds(20, 120, 640, 300);
		p.add(txtArea);
		
		texto = new JLabel("");
		texto.setBounds(20, 420, 650, 40);
		p.add(texto);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnMostrar) {
			txtArea.setText(le.abrir());
		}
		
		if(e.getSource() == btnSalvar) {
			le.salvar(txtArea.getText());
		}
		
		if(e.getSource() == btnMaisc) { //Deixando as letras em maiúsculo
			le.salvar(txtArea.getText().toUpperCase());
			txtArea.setText(le.abrir());
		}
		
		if(e.getSource() == btnTotln) { //Vendo total de linhas
			try {
				texto.setText("Total de linhas: " + le.contarLn() + "\n");
			} catch (IOException err) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo: " + err);
			}
		}
		
		if(e.getSource() == btnCaract) { //Vendo total de caracteres
			try {
				texto.setText("Quantidade total de caracteres: " + le.contarCaract());
			} catch (IOException err) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo: " + err);
			}
		}
	}
	
	public static void main(String[] args) {
		le = new LerEscrever();
		new FormEdicao().setVisible(true);
	}

}
