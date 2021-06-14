package viwers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import contollers.ProcessaViagens;
import models.Viagem;

public class FormViagens extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel p;
	private JLabel texto;
	private JTextField entrada; 
	private JButton botao; 
	private JTextArea saida; 
	
	FormViagens(){
		setTitle("Registro de Viagens");
		setSize(800, 600);
		p = new JPanel();
		setContentPane(p);
		setLayout(null);//Grid, Border, Null, etc
		
		texto = new JLabel("Digite os dados da viagem ");
		texto.setBounds(20, 20, 200, 30);
		entrada = new JTextField();
		entrada.setBounds(20, 50, 300, 30);
		botao = new JButton("Adicionar");
		botao.setBounds(20, 80, 200, 30);
		botao.addActionListener(this); 
		saida = new JTextArea(getDados());
		saida.setBounds(20, 110, 500, 300);
		
		p.add(texto);
		p.add(entrada);
		p.add(botao);
		p.add(saida);
	}
	
	public String getDados() {
		String retorno = "Id\tOrigem\tDestino\tDistância\tVelocidade\tTempo\n\n";
		for (Viagem v : ProcessaViagens.viagens) {
			retorno += v.toString();
		}
		retorno += "\nTotal de tempo: " + String.format("%.2f",ProcessaViagens.getTempoTotal());
		return retorno;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botao) {
			Viagem v = new Viagem();
			String [] campos = entrada.getText().split(","); // Separa os valores por vírgula e joga no vetor
			v.setId(Integer.valueOf(campos[0]));
			v.setOrigem(campos[1]);
			v.setDestino(campos[2]);
			v.setDistancia(Integer.valueOf(campos[3]));
			v.setVelocidade(Integer.valueOf(campos[4]));
			ProcessaViagens.viagens.add(v);
			saida.setText(getDados());

		}
	}
	
	public static void main(String[] args) {
		ProcessaViagens.viagens.add(new Viagem(1, "campinas", "Indaituba", 200, 100));
		ProcessaViagens.viagens.add(new Viagem(2, "campinas", "São Paulo", 400, 110));
		ProcessaViagens.viagens.add(new Viagem(3, "campinas", "Rio de Janeiro", 500, 120));
		ProcessaViagens.viagens.add(new Viagem(4, "campinas", "Americana", 600, 100));
		
		new FormViagens().setVisible(true);
	}

}
