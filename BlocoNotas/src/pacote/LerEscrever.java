package pacote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LerEscrever {
	BufferedReader br; 
	BufferedWriter bw;
	String arquivo = "./bd/arquivo.txt";
	
	void salvar(String conteudo) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo,false));
			bw.write(conteudo);
			bw.close();
		} catch (IOException e){
			JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + e);
		}
	}
	
	String abrir() {
		String retorno = "";
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			while((linha = br.readLine()) != null) {
				retorno += linha + "\n"; 
			}
			br.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro! Arquivo não encontrado: " + e);
		} catch (IOException e){
			JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo: " + e);
		}
		return retorno;
	}
	
	int contarLn() throws IOException {
		int resp = 0; 
		br = new BufferedReader(new FileReader(arquivo));
		while((br.readLine()) != null) {
			resp += 1;
		
		}
		return resp;	
	}
	
	int contarCaract() throws IOException {
		int resp = 0;
		String linha = "";
		br = new BufferedReader(new FileReader(arquivo));
		while((linha = br.readLine()) != null) {
			resp += linha.length();	
		}
		return resp;
	}
}
